package com.example.unitconversion.dataTypes

interface DataInterface {
    val name: String
    val listOfUnits: List<String>

    fun onButtonClick(startingUnit: String, desiredUnit: String, unitToConvert: Double): Double{
        var value = unitToConvert
        return value
    }

    //To avoid exponential complexity, this function takes the user's value and...
    //...converts it into a default, which all future conversions can reference...
    //...eliminating the need to write code for each conversion case

    //Default Unit - *SELECT UNIT*
    fun convertToDefaultUnit(startingUnit: String, valueToConvert: Double): Double{
        var value = valueToConvert
        return value
    }

}