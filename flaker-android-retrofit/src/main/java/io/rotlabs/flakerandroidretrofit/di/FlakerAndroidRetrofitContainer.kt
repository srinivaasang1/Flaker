package io.rotlabs.flakerandroidretrofit.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import io.rotlabs.di.FlakerDataContainer
import io.rotlabs.flakerandroidretrofit.ui.FlakerViewModel
import io.rotlabs.flakerdb.networkrequest.data.NetworkRequestRepo
import io.rotlabs.flakerprefs.PrefDataStore
import io.rotlabs.flakerretrofit.di.FlakerRetrofitCoreContainer

object FlakerAndroidRetrofitContainer {

    private var networkRequestRepo: NetworkRequestRepo? = null

    private var prefDataStore: PrefDataStore? = null

    private fun networkRequestRepo() = networkRequestRepo!!

    private fun prefDataStore() = prefDataStore!!

    fun init(appContext: Context) {
        FlakerRetrofitCoreContainer.init(FlakerDataContainer(appContext))
        networkRequestRepo = FlakerRetrofitCoreContainer.networkRequestRepo()
        prefDataStore = FlakerRetrofitCoreContainer.prefDataStore()
    }

    val flakerViewModelFactory: ViewModelProvider.Factory = viewModelFactory {
        initializer {
            val savedStateHandle = createSavedStateHandle()
            FlakerViewModel(networkRequestRepo(), prefDataStore(), savedStateHandle)
        }
    }
}