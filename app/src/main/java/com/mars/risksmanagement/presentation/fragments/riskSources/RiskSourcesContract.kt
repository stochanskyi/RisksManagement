package com.mars.risksmanagement.presentation.fragments.riskSources

import com.mars.risksmanagement.presentation.common.mvp.IBaseFragment
import com.mars.risksmanagement.presentation.common.mvp.IBasePresenter

interface RiskSourcesContract {

    interface ViewContract : IBaseFragment {
        fun setItems(items: List<IRiskViewModel>)
    }

    interface PresentationContract : IBasePresenter<ViewContract> {
        fun onRiskSelectedChanged(id: Long, isSelected: Boolean)
    }

    interface IRiskViewModel

    interface IRiskGroupViewModel : IRiskViewModel {
        val name: String
    }

    interface IRiskSourceViewModel : IRiskViewModel{
        val id: Long
        val name: String
        val isSelected: Boolean

        fun changeSelected(isSelected: Boolean)
    }
}