package com.mars.risksmanagement.data.riskSources

interface RiskSourcesRepository {

    fun getSources(): List<IRiskSource>

    fun getGroups(): List<ISourceGroup>

    interface ISourceGroup {
        val id: Long
        val name: String
    }

    interface IRiskSource {
        val id: Long
        val name: String
        val group: ISourceGroup
    }
}