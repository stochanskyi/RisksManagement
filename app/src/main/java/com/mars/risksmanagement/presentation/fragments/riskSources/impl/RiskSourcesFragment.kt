package com.mars.risksmanagement.presentation.fragments.riskSources.impl

import androidx.recyclerview.widget.LinearLayoutManager
import com.mars.risksmanagement.R
import com.mars.risksmanagement.presentation.common.mvp.BaseFragment
import com.mars.risksmanagement.presentation.fragments.riskSources.RiskSourcesContract
import com.mars.risksmanagement.presentation.fragments.riskSources.RiskSourcesContract.PresentationContract
import com.mars.risksmanagement.presentation.fragments.riskSources.RiskSourcesContract.ViewContract
import com.mars.risksmanagement.presentation.fragments.riskSources.adapter.RiskSourcesAdapter
import kotlinx.android.synthetic.main.fragment_risk_sources.*

class RiskSourcesFragment : BaseFragment<PresentationContract>(R.layout.fragment_risk_sources),
    ViewContract {

    companion object {
        fun newInstance(): RiskSourcesFragment = RiskSourcesFragment()
    }

    override val presenter: PresentationContract = RiskSourcesPresenter()

    override fun onInitPresenter() {
        presenter.view = this
    }

    override fun initViews() {
        risksRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = RiskSourcesAdapter { id, isSelected ->
                presenter.onRiskSelectedChanged(id, isSelected)
            }
        }
    }

    override fun setItems(items: List<RiskSourcesContract.IRiskViewModel>) {
        (risksRecycler.adapter as? RiskSourcesAdapter)?.setItems(items)
    }
}