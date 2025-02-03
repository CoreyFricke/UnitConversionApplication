package com.example.unitconversion.dataTypes

import java.math.RoundingMode

class Temperature : DataInterface {
    override val name = "Temperature"
    override val listOfUnits = listOf(
        "Fahrenheit",
        "Celsius",
        "Kelvin"
    )

    override fun onButtonClick(startingUnit: String, desiredUnit: String, unitToConvert: Double): Double{
        var value = convertToDefaultUnit(startingUnit, unitToConvert)

        when (desiredUnit){
            listOfUnits[1] -> {
                value = (value - 32) * 5/9
            }
            listOfUnits[2] -> {
                value = (value - 32) * 5/9 + 273.15
            }
        }

        val roundedValue = value.toBigDecimal().setScale(2, RoundingMode.UP).toDouble()
        return roundedValue
    }

    //Default Unit - Fahrenheit
    override fun convertToDefaultUnit(startingUnit: String, valueToConvert: Double) : Double{
        var value = valueToConvert

        if(startingUnit == "Celsius"){
            value = (value * 1.8) + 32
        }
        else if (startingUnit == "Kelvin"){
            value = (value - 273.15) * 1.8 + 32
        }

        return value
    }


}