package com.mars.risksmanagement.presentation.fragments.riskSources.adapter.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mars.risksmanagement.R

abstract class BaseRiskViewHolder protected constructor(view: View): RecyclerView.ViewHolder(view) {

    open fun release() {}
}