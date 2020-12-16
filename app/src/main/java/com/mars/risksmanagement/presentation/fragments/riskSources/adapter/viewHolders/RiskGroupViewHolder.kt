package com.mars.risksmanagement.presentation.fragments.riskSources.adapter.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mars.risksmanagement.R
import com.mars.risksmanagement.presentation.fragments.riskSources.RiskSourcesContract
import kotlinx.android.synthetic.main.view_holder_sources_group.view.*

class RiskGroupViewHolder private constructor(view: View) : BaseRiskViewHolder(view) {

    companion object {
        fun create(parent: ViewGroup): RiskGroupViewHolder {
            return RiskGroupViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_holder_sources_group, parent, false)
            )
        }
    }

    fun bind(model: RiskSourcesContract.IRiskGroupViewModel) {
        with(itemView) {
            textGroup.text = model.name
        }
    }
}