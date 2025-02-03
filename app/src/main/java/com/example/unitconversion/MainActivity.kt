package com.example.unitconversion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.unitconversion.UnitConversionActivity.UnitConversionScreen
import com.example.unitconversion.UnitConversionActivity.UnitConversionVM
import com.example.unitconversion.ui.theme.UnitConversionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConversionTheme {
                UnitConversionScreen().Base(UnitConversionVM())
            }
        }
    }
}