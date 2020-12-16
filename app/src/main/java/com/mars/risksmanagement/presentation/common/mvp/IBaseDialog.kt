package com.mars.risksmanagement.presentation.common.mvp

interface IBaseDialog: IBaseView {
    val dialogTag: String?

    fun close()
}