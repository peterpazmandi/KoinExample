package com.inspirecoding.koinexample.modul

import com.inspirecoding.koinexample.model.Burger
import com.inspirecoding.koinexample.model.Drink
import com.inspirecoding.koinexample.model.Guest
import com.inspirecoding.koinexample.model.Order
import com.inspirecoding.koinexample.viewmodel.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var appModule = module {
    factory { Guest() }
    factory { Burger() }
    single { Drink() }
    factory { Order(get(), get(), get()) }
}

val mainActivityViewModelModule = module {
    viewModel { MainActivityViewModel() }
}