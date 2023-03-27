package com.kotlin.functional


class FunctionalCalculatorService {

    internal fun calculateFinancialReport(person: Person): FinancialReport =
        FinancialReport(
            totalCurrentAccountStatus = sumAllValuesByField(person) { it.currentAccountStatus },
            totalIncomingPayments = sumAllValuesByField(person) { it.incomingPayments },
            totalMoneySpent = sumAllValuesByField(person) { it.moneySpent },
            totalMonthlyIncome = sumAllValuesByField(person) { it.monthlyIncome },
        )

    private fun sumAllValuesByField(person: Person, fieldSupplier: (Person) -> Double): Double =
        person.allSubunits.sumOf { fieldSupplier(it) } + fieldSupplier(person)
}