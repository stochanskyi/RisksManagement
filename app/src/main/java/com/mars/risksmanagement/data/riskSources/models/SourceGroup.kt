package com.mars.risksmanagement.data.riskSources.models

import com.mars.risksmanagement.data.riskSources.RiskSourcesRepository

data class SourceGroup(
    override val id: Long,
    override val name: String
) : RiskSourcesRepository.ISourceGroup