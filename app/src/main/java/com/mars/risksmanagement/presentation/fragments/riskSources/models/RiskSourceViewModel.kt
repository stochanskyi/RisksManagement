package com.mars.risksmanagement.presentation.fragments.riskSources.models

import com.mars.risksmanagement.presentation.fragments.riskSources.RiskSourcesContract

data class RiskSourceViewModel(
    override val id: Long,
    override val name: String,
    override var isSelected: Boolean = false
) : RiskSourcesContract.IRiskSourceViewModel {
    override fun changeSelected(isSelected: Boolean) {
        this.isSelected = isSelected
    }
}