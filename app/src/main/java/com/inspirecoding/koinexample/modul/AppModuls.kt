package com.inspirecoding.koinexample.modul

import com.inspirecoding.koinexample.model.Burger
import com.inspirecoding.koinexample.model.Drink
import com.inspirecoding.koinexample.model.Guest
import com.inspirecoding.koinexample.model.Order
import org.koin.dsl.module

var appModul = module {
    factory { Guest() }
    factory { Burger() }
    single { Drink() }
    factory { Order(get(), get(), get()) }
}