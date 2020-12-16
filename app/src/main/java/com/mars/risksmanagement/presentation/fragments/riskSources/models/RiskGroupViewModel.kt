package com.mars.risksmanagement.presentation.fragments.riskSources.models

import com.mars.risksmanagement.presentation.fragments.riskSources.RiskSourcesContract

data class RiskGroupViewModel(
    override val name: String
) : RiskSourcesContract.IRiskGroupViewModel