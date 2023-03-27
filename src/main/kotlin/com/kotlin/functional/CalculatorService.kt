package com.kotlin.functional

import org.springframework.stereotype.Service

@Service
internal class CalculatorService {
    internal fun calculateFinancialReport(person: Person) =
        FinancialReport(
            totalCurrentAccountStatus = sumAllCurrentAccountStatus(person),
            totalIncomingPayments = sumAllIncomingPayments(person),
            totalMoneySpent = sumAllMoneySpent(person),
            totalMonthlyIncome = sumAllMonthlyIncome(person),
        )

    private fun sumAllCurrentAccountStatus(person: Person): Double {
        return person.children.sumOf { sumAllCurrentAccountStatus(it) } + person.currentAccountStatus
    }

    private fun sumAllIncomingPayments(person: Person): Double {
        return person.children.sumOf { sumAllIncomingPayments(it) } + person.incomingPayments
    }

    private fun sumAllMoneySpent(person: Person): Double {
        return person.children.sumOf { sumAllMoneySpent(it) } + person.moneySpent
    }

    private fun sumAllMonthlyIncome(person: Person): Double {
        return person.children.sumOf { sumAllMonthlyIncome(it) } + person.monthlyIncome
    }

}