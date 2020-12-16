package com.mars.risksmanagement.presentation.fragments.riskSources.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mars.risksmanagement.data.riskSources.RiskSourcesRepository
import com.mars.risksmanagement.presentation.fragments.riskSources.RiskSourcesContract
import com.mars.risksmanagement.presentation.fragments.riskSources.adapter.viewHolders.BaseRiskViewHolder
import com.mars.risksmanagement.presentation.fragments.riskSources.adapter.viewHolders.RiskGroupViewHolder
import com.mars.risksmanagement.presentation.fragments.riskSources.adapter.viewHolders.RiskSourceViewHolder
import com.mars.risksmanagement.utils.clearAndAdd

class RiskSourcesAdapter(
    private val onSelectedChangedBlock: (Long, Boolean) -> Unit
) : RecyclerView.Adapter<BaseRiskViewHolder>() {

    companion object {
        private const val VIEW_TYPE_GROUP = 1
        private const val VIEW_TYPE_SOURCE = 2
    }

    private val items: MutableList<RiskSourcesContract.IRiskViewModel> = mutableListOf()

    fun setItems(items: List<RiskSourcesContract.IRiskViewModel>) {
        this.items.clearAndAdd(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRiskViewHolder {
        return when (viewType) {
            VIEW_TYPE_GROUP -> RiskGroupViewHolder.create(parent)
            VIEW_TYPE_SOURCE -> RiskSourceViewHolder.create(parent)
            else -> throw IllegalStateException()
        }
    }

    override fun onBindViewHolder(holder: BaseRiskViewHolder, position: Int) {
        when (holder) {
            is RiskGroupViewHolder -> holder.bind(items[position] as RiskSourcesContract.IRiskGroupViewModel)
            is RiskSourceViewHolder -> {
                val item = items[position] as RiskSourcesContract.IRiskSourceViewModel
                holder.bind(item) {
                    (item).changeSelected(it)
                    onSelectedChangedBlock(item.id, it)
                }
            }
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is RiskSourcesContract.IRiskGroupViewModel -> VIEW_TYPE_GROUP
            is RiskSourcesContract.IRiskSourceViewModel -> VIEW_TYPE_SOURCE
            else -> throw IllegalStateException()
        }
    }
}