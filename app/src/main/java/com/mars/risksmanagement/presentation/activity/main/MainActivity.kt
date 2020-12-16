package com.mars.risksmanagement.presentation.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mars.risksmanagement.R
import com.mars.risksmanagement.presentation.fragments.riskSources.impl.RiskSourcesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, RiskSourcesFragment.newInstance())
            .commit()
    }
}