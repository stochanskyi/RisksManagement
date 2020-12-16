package com.mars.risksmanagement.presentation.common.mvp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.mars.risksmanagement.presentation.common.extensions.BackPressListener
import com.mars.risksmanagement.presentation.common.extensions.FragmentHolder

abstract class BaseFragment<T: IBasePresenter<IBaseView>>: Fragment,
    IBaseFragment,
    FragmentHolder,
    BackPressListener {

    constructor()
    constructor(layoutId: Int) : super(layoutId)

    abstract val presenter: T

    abstract fun onInitPresenter()

    abstract fun initViews()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        onInitPresenter()
        super.onViewCreated(view, savedInstanceState)
        initViews()
        presenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onDestroyView() {
        presenter.release()
        super.onDestroyView()
    }

    override fun close() {
        parentFragment?.let {
            (it as? FragmentHolder)?.requestCloseChild()
                ?: it.childFragmentManager.popBackStack()
        } ?: activity?.let {
            (it as? FragmentHolder)?.requestCloseChild()
                ?: it.supportFragmentManager.popBackStack()
        }
    }

    override fun handleError(e: Throwable) {
        //TODO function to handle error
    }

    override fun requestCloseChild() {
        childFragmentManager.popBackStack()
    }

    override fun onBackPressed(): Boolean {
        if (onBackPressedChildHandled()) return true
        if (onBackPressedCloseChild()) return true
        return false
    }

    private fun onBackPressedChildHandled(): Boolean {
        for (fragment in childFragmentManager.fragments.reversed()) {
            if (fragment is BackPressListener && fragment.onBackPressed()) return true
        }
        return false
    }

    private fun onBackPressedCloseChild(): Boolean {
        return if (childFragmentManager.backStackEntryCount > 0) {
            childFragmentManager.popBackStack()
            true
        } else false
    }
}