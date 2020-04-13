package com.rusmyhal.fragmentfactoryexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.fragment.android.setupKoinFragmentFactory
import org.koin.ext.getOrCreateScope

class MainActivity : AppCompatActivity(), HomeFragment.NavigationListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        setupKoinFragmentFactory()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment::class.java, null)
                .commit()
        }
    }

    override fun navigateToDetails(args: Bundle?) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, DetailsFragment::class.java, args)
            .addToBackStack(DetailsFragment.TAG)
            .commit()
    }
}
