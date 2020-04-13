package com.rusmyhal.fragmentfactoryexample

import androidx.lifecycle.ViewModel

class DetailsViewModel(private val dependency: SomeDependency) : ViewModel() {

    fun getHello(): String = dependency.giveHello()
}