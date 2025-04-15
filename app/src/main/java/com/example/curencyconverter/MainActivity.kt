package com.example.curencyconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme { // Gunakan theme bawaan
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CurrencyConverterUI()
                }
            }
        }
    }
}

@Composable
fun CurrencyConverterUI() {
    var dollarInput by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    val conversionRate = 16851.0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .background(Color(0xFFFFC0CB)), // Background pink
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Title
        Text(
            text = "Currency App",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF880E4F)
        )

        // Author
        Text(
            text = "by : Yasmin Putri",
            fontSize = 16.sp,
            color = Color(0xFFAD1457),
            modifier = Modifier.padding(top = 4.dp, bottom = 24.dp)
        )

        // Label
        Text(
            text = "🇺🇸 USD → 🇮🇩 IDR",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF880E4F)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Enter USD amount",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFAD1457),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 4.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "💲",
                fontSize = 26.sp,
                modifier = Modifier.padding(end = 8.dp)
            )

            OutlinedTextField(
                value = dollarInput,
                onValueChange = { dollarInput = it },
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val value = dollarInput.toDoubleOrNull()
                result = if (value != null) {
                    "Rp ${"%,.2f".format(value * conversionRate)}"
                } else {
                    "Invalid input"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD81B60))
        ) {
            Text("Convert", fontSize = 18.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (result.isNotEmpty()) {
            Text(
                text = result,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF880E4F)
            )
        }
    }
}
