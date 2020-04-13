package com.rusmyhal.fragmentfactoryexample.di

import com.rusmyhal.fragmentfactoryexample.DetailsFragment
import com.rusmyhal.fragmentfactoryexample.DetailsViewModel
import com.rusmyhal.fragmentfactoryexample.HomeFragment
import com.rusmyhal.fragmentfactoryexample.SomeDependency
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val fragmentModules = module {
    fragment { HomeFragment() }
    fragment { DetailsFragment(get()) }
}

private val viewModelsModule = module {
    viewModel { DetailsViewModel(get()) }
}

private val dataModule = module {
    single { SomeDependency() }
}

val appModules = listOf(fragmentModules, viewModelsModule, dataModule)