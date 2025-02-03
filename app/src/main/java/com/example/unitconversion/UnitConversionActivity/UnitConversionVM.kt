package com.example.unitconversion.UnitConversionActivity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.unitconversion.dataTypes.Length
import com.example.unitconversion.dataTypes.Temperature

class UnitConversionVM: ViewModel() {
    //DropDown
    val listOfClasses = listOf(
        Temperature(),
        Length()
    )

    //ClassSelectionDropDown
    var isClassExpanded by mutableStateOf(false)
    var selectedClass by mutableStateOf(listOfClasses[0].name)
    //UnitSelectionDropDown
    var isUnitExpanded by mutableStateOf(false)
    var selectedUnit by mutableStateOf(listOfClasses[0].listOfUnits[0])

    var selectedIndex by mutableIntStateOf(0)

    private var unitToConvert by mutableStateOf("")
    private var convertedUnit by mutableStateOf("")

    //Setters
    fun setterUnitToConvert(input: String){
        unitToConvert = input
    }
    fun setterConvertedUnit(input: Double){
        convertedUnit = input.toString()
    }

    //Getters
    fun getterUnitToConvert(): String{
        return unitToConvert
    }
    fun getterConvertedUnit(): String{
        return convertedUnit
    }
}