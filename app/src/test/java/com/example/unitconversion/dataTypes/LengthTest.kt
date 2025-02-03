package com.example.unitconversion.dataTypes

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class LengthTest{

    //Default Conversion Unit -> Inches
    @Test
    fun WhenDefaultConversionIsTrue(){
        val startingUnit = "Meters"
        val valueToConvert = 2.0

        val result = Length().convertToDefaultUnit(startingUnit, valueToConvert)
        assertThat(result).isEqualTo(78.74)
    }

    @Test
    fun whenYardsConversionIsTrue(){
        val startingUnit = "Inches"
        val desiredUnit = "Yards"
        val valueToConvert = 150.0

        val result = Length().onButtonClick(startingUnit, desiredUnit, valueToConvert)
        assertThat(result).isEqualTo(4.17)
    }

}