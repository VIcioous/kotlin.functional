package com.kotlin.functional

object FinancialReportFixtures {
    fun correctFinancialReportInPLN() =
        FinancialReport(
            totalCurrentAccountStatus = 6500.0,
            totalMoneySpent = 600.0,
            totalMonthlyIncome = 1800.0,
            totalIncomingPayments = 2000.0
        )
}