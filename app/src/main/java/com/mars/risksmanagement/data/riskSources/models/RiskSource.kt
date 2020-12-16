package com.mars.risksmanagement.data.riskSources.models

import com.mars.risksmanagement.data.riskSources.RiskSourcesRepository

data class RiskSource(
    override val id: Long,
    override val name: String,
    override val group: RiskSourcesRepository.ISourceGroup
) : RiskSourcesRepository.IRiskSource