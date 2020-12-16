package com.mars.risksmanagement.presentation.fragments.riskSources.impl

import com.mars.risksmanagement.data.riskSources.RiskSourcesRepository
import com.mars.risksmanagement.data.riskSources.RiskSourcesRepository.IRiskSource
import com.mars.risksmanagement.data.riskSources.RiskSourcesRepository.ISourceGroup
import com.mars.risksmanagement.data.riskSources.RiskSourcesRepositoryImpl
import com.mars.risksmanagement.presentation.common.mvp.BasePresenter
import com.mars.risksmanagement.presentation.fragments.riskSources.RiskSourcesContract.*
import com.mars.risksmanagement.presentation.fragments.riskSources.models.RiskGroupViewModel
import com.mars.risksmanagement.presentation.fragments.riskSources.models.RiskSourceViewModel

class RiskSourcesPresenter : BasePresenter<ViewContract>(), PresentationContract {
    private val repository: RiskSourcesRepository = RiskSourcesRepositoryImpl()

    private lateinit var riskSources: List<IRiskSource>

    private val selectedSources: MutableSet<IRiskSource> = mutableSetOf()

    override fun onStart() {
        riskSources = repository.getSources()
        view?.setItems(riskSources.toViewModels())
    }

    override fun onRiskSelectedChanged(id: Long, isSelected: Boolean) {
        val item = riskSources.firstOrNull { it.id == id } ?: return
        if (isSelected) selectedSources.add(item)
        else selectedSources.remove(item)
    }

    private fun List<IRiskSource>.toViewModels(): List<IRiskViewModel> {
        val items: MutableList<IRiskViewModel> = mutableListOf()
        items.add(this.first().group.toViewModel())

        var previousItem: IRiskSource? = null
        forEach { item ->

            previousItem?.let {
                if (items.last() is IRiskSourceViewModel && it.group.id != item.group.id) {
                    items.add(item.group.toViewModel())
                }
            }
            items.add(item.toViewModel())
            previousItem = item
        }
        return items.toList()
    }

    private fun ISourceGroup.toViewModel(): IRiskGroupViewModel {
        return RiskGroupViewModel(name)
    }

    private fun IRiskSource.toViewModel(): IRiskSourceViewModel {
        return RiskSourceViewModel(id, name)
    }
}