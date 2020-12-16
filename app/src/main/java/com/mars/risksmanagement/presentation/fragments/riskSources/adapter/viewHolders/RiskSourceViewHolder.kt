package com.mars.risksmanagement.presentation.fragments.riskSources.adapter.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mars.risksmanagement.R
import com.mars.risksmanagement.presentation.fragments.riskSources.RiskSourcesContract
import kotlinx.android.synthetic.main.view_holder_risk_source.view.*

class RiskSourceViewHolder private constructor(view: View) : BaseRiskViewHolder(view) {

    companion object {
        fun create(parent: ViewGroup): RiskSourceViewHolder {
            return RiskSourceViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_holder_risk_source, parent, false)
            )
        }
    }

    fun bind(
        model: RiskSourcesContract.IRiskSourceViewModel,
        onSelectedChangedBlock: (Boolean) -> Unit
    ) {
        with(itemView.checkBoxRiskSource) {
            isChecked = model.isSelected
            setOnCheckedChangeListener { _, isChecked ->
                onSelectedChangedBlock(isChecked)
            }
            text = model.name
        }
    }

    override fun release() {
        itemView.checkBoxRiskSource.setOnCheckedChangeListener(null)
    }
}