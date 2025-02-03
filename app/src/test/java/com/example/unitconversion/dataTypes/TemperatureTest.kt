package com.example.unitconversion.dataTypes

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TemperatureTest{

    //Default Conversion Unit -> Fahrenheit
    @Test
    fun whenDefaultConversionIsTrue(){
        val startingUnit = "Celsius"
        val valueToConvert = 32.0

        val result = Temperature().convertToDefaultUnit(startingUnit, valueToConvert)
        assertThat(result).isEqualTo(89.6)
    }

    @Test
    fun whenCelsiusConversionIsTrue(){
        val startingUnit = "Celsius"
        val desiredUnit = "Kelvin"
        val valueToConvert = 32.0

        val result = Temperature().onButtonClick(startingUnit, desiredUnit, valueToConvert)
        assertThat(result).isEqualTo(305.15)
    }
}