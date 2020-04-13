package com.rusmyhal.fragmentfactoryexample.di

import androidx.fragment.app.FragmentFactory
import com.rusmyhal.fragmentfactoryexample.*
import org.koin.androidx.fragment.android.KoinFragmentFactory
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val fragmentModules = module {
    fragment { HomeFragment() }
    fragment { DetailsFragment(get()) }
    single<FragmentFactory> { KoinFragmentFactory() }
}

private val viewModelsModule = module {
    viewModel { DetailsViewModel(get()) }
}

private val dataModule = module {
    single { SomeDependency() }
}

val appModules = listOf(fragmentModules, viewModelsModule, dataModule)