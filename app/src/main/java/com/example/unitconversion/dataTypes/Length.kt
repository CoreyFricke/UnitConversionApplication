package com.example.unitconversion.dataTypes

import java.math.RoundingMode

class Length : DataInterface {
    override val name = "Length"
    override val listOfUnits = listOf(
        "Inch",
        "Feet",
        "Yards",
        "Meters"
    )

    override fun onButtonClick(startingUnit: String, desiredUnit: String, unitToConvert: Double): Double{
        var value = convertToDefaultUnit(startingUnit, unitToConvert)

        when (desiredUnit){
            listOfUnits[1] -> {
                value /= 12
            }
            listOfUnits[2] -> {
                value /= 36
            }
            listOfUnits[3] -> {
                value /= 39.37
            }
        }

        val roundedValue = value.toBigDecimal().setScale(2, RoundingMode.UP).toDouble()
        return roundedValue
    }

    //Default Unit - Inches
    override fun convertToDefaultUnit(startingUnit: String, valueToConvert: Double) : Double{
        var value = valueToConvert

        if(startingUnit == "Meters"){
            value *= 39.37
        }
        else if(startingUnit == "Feet"){
            value *= 12
        }
        else if(startingUnit == "Yards"){
            value *= 36
        }

        return value
    }
}