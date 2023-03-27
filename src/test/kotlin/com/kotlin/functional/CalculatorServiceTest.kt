package com.kotlin.functional

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CalculatorServiceTest {

    private val testedService = CalculatorService()

    @Test
    fun shouldCorrectlyGenerateFinancialReport() {
        //given
        val person = FamilyFixtures.multigenerationalFamily()

        //when
        val report = testedService.calculateFinancialReport(person)

        //then
        assertThat(report).isEqualTo(FinancialReportFixtures.correctFinancialReportInPLN())
    }
}