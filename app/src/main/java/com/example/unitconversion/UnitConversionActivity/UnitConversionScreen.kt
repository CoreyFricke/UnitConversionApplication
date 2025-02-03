package com.example.unitconversion.UnitConversionActivity

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class UnitConversionScreen{
    @Preview
    @Composable
    fun BasePreview(){
        val vm = UnitConversionVM()
        Base(vm)
    }

    @Composable
    fun Base(viewModel: UnitConversionVM){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .size(60.dp)
            ) {
            }
            Text(
                text = "Unit Conversion",
                color = Color.Black,
                fontSize = 50.sp,
                fontStyle = FontStyle.Italic
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .background(Color.Black)
                    .padding(bottom = 32.dp)
            ){}
            ExpenditureType(viewModel)
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Starting Values",
                color = Color.Black,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            UserInput(viewModel)
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Result",
                color = Color.Black,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Result(viewModel)
            ListOptions(viewModel)
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun UserInput(viewModel: UnitConversionVM){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                TextField(
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.DarkGray,
                    ),
                    modifier = Modifier
                        .width(200.dp)
                        .padding(4.dp),
                    value = viewModel.getterUnitToConvert(),
                    onValueChange = {viewModel.setterUnitToConvert(it)},
                    label = {Text (
                        text = "Starting Value",
                        color = Color.White
                    )}
                )
                ExposedDropdownMenuBox(
                    expanded = viewModel.isUnitExpanded,
                    onExpandedChange = {viewModel.isUnitExpanded = !viewModel.isUnitExpanded}
                ) {
                    TextField(
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.DarkGray,
                            unfocusedTrailingIconColor = Color.White,
                            unfocusedTextColor = Color.White,
                            focusedTrailingIconColor = Color.White,
                            focusedTextColor = Color.White
                        ),
                        modifier = Modifier
                            .menuAnchor(),
                        value = viewModel.selectedUnit,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = viewModel.isUnitExpanded)}
                    )

                    ExposedDropdownMenu(
                        expanded = viewModel.isUnitExpanded,
                        onDismissRequest = {viewModel.isUnitExpanded = false}
                    ){
                        viewModel.listOfClasses[viewModel.selectedIndex].listOfUnits.forEachIndexed { index, text ->
                            DropdownMenuItem(
                                text = {Text (
                                    text = text
                                )},
                                onClick = {
                                    viewModel.selectedUnit = text
                                    viewModel.isUnitExpanded = false
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                            )
                        }
                    }
                }
            }
    }
    @Composable
    fun Result(viewModel: UnitConversionVM){
        Box(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .background(Color.Gray)
                .height(60.dp)
                .width(300.dp),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = viewModel.getterConvertedUnit() + " " + viewModel.getterCalcUnitName(),
                color = Color.Black,
                fontSize = 20.sp,
            )
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ExpenditureType(
        viewModel: UnitConversionVM
    ){
        Text(
            modifier = Modifier
                .padding(
                    top = 32.dp,
                    bottom = 4.dp
                ),
            text = "Measurement",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        ExposedDropdownMenuBox(
            expanded = viewModel.isClassExpanded,
            onExpandedChange = {viewModel.isClassExpanded = !viewModel.isClassExpanded}
        ) {
            TextField(
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.DarkGray,
                    unfocusedTrailingIconColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedTrailingIconColor = Color.White,
                    focusedTextColor = Color.White
                ),
                modifier = Modifier
                    .menuAnchor(),
                value = viewModel.selectedClass,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = viewModel.isClassExpanded)}
            )

            ExposedDropdownMenu(
                expanded = viewModel.isClassExpanded,
                onDismissRequest = {viewModel.isClassExpanded = false}
            ){
                viewModel.listOfClasses.forEachIndexed { index, text ->
                    DropdownMenuItem(
                        text = {Text (text = text.name)},
                        onClick = {
                            viewModel.selectedClass = viewModel.listOfClasses[index].name
                            viewModel.selectedUnit = viewModel.listOfClasses[index].listOfUnits[0]
                            viewModel.selectedIndex = index
                            viewModel.isClassExpanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }
    }

    @Composable
    fun ListOptions(viewModel: UnitConversionVM){
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(8.dp),
            columns = GridCells.Fixed(3)
        ) {
            items(viewModel.listOfClasses[viewModel.selectedIndex].listOfUnits){conversion ->
                ListItem(conversion, viewModel)
            }
        }
    }

    @Composable
    fun ListItem(conversion: String, viewModel: UnitConversionVM) {
        val context = LocalContext.current
        Button(
            modifier = Modifier
                .padding(4.dp),
            colors = ButtonColors(Color.DarkGray, Color.White, Color.DarkGray, Color.White),
            onClick = {
                viewModel.setterCalcUnitName(conversion)
                convertUnit(viewModel, conversion, context)
            }) {
            Text(
                text = conversion,
                fontSize = 13.sp
            )
        }
    }

    private fun convertUnit(viewModel: UnitConversionVM, conversion: String, context: Context){
        if(validateUserInput(viewModel)){
            viewModel.setterConvertedUnit(viewModel.listOfClasses[viewModel.selectedIndex].onButtonClick(viewModel.selectedUnit, conversion, viewModel.getterUnitToConvert().toDouble()))
        }
        else{
            Toast.makeText(context, "Invalid Input - Ensure your starting value is only numbers", Toast.LENGTH_LONG).show()
        }
    }

    private fun validateUserInput(viewModel: UnitConversionVM) : Boolean{
        val userDouble = viewModel.getterUnitToConvert()
        return userDouble.toDoubleOrNull() != null
    }
}