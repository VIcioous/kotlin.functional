package com.kotlin.functional

sealed interface Currency {
    object PLN : Currency
    object EUR : Currency
    object USD : Currency
    object GBP : Currency

    fun getCurrencyRatio(): (Double) -> Double {
        return when (this) {
            is PLN -> { value -> value / 1 }
            is EUR -> { value -> value / 4.68 }
            is GBP -> { value -> value / 5.33 }
            is USD -> { value -> value / 4.35 }
        }
    }
}
