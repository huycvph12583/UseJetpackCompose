package com.example.usejetpackcompose

import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.usejetpackcompose.ui.theme.UseJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UseJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
//                    Greeting("Huy Chu")
                    ButtonView()
                }
            }
        }
    }
}

@Composable
fun ButtonView() {
    Column(modifier = Modifier.fillMaxSize().padding(10.dp)) {
        // Simple Button
        Button(onClick = { /*TODO*/ }) {
            Text(text = "ButtonSimple")
        }
        // Change color background and conner button
        Button(
            onClick = {
                // your onclick code
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            shape = CutCornerShape(0)
        ) {
            Text(text = "Button with gray background", color = Color.White)
        }
        // Button with multiple text
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Click")
            Spacer(modifier = Modifier.width(width = 10.dp))
            Text(text = "Here", color = Color.Black)
        }
        // Button with icon
        Button(onClick = { /*TODO*/ }) {
            Image(imageVector = Icons.Default.ShoppingCart, contentDescription = "Add to cart")
            Text(text = "Add to cart", Modifier.padding(start = 10.dp))
        }
        // Button border
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Blue),
            border = BorderStroke(1.dp, color = Color.Red)
        ) {
            Text(text = "Button with border", color = Color.White)
        }
        // Button elevation
        Button(
            onClick = {
                // your onclick code here
            },
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 15.dp,
                disabledElevation = 0.dp
            )
        ) {
            Text(text = "Button with elevation")
        }
    }
}

@Composable
fun TextFiled1() {
    // biến text dùng để lưu tru du liệu di người dung nhap
    var text by rememberSaveable { mutableStateOf("") }
    // biến passwordVisible dung để tạo giá trị ẩn hiện của password
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    Log.d("ABCD", "TextFiled1:  $text")
    Column(modifier = Modifier.fillMaxSize()) {
        // Simple text filed

        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = { Text(text = "Simple Text") },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Your Placeholder/Hint") },
        )

        // Label And PlaceHolder /Hint
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = { Text(text = "Label And PlaceHolder /Hint") },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Your Placeholder/Hint") },
        )
        // TextField With InputType
        TextField(
            value = text,
            label = { Text(text = "Number Input Type") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { it ->
                text = it
            }
        )
        /*  KeyboardType.Text
           KeyboardType.Text
           KeyboardType.Ascii
           KeyboardType.Number
           KeyboardType.Phone
           KeyboardType.Uri
           KeyboardType.Email
           KeyboardType.Password
           KeyboardType.NumberPassword*/

        // TextFieldWithIcons

        OutlinedTextField(
            value = text,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "emailIcon"
                )
            },
            // trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
            onValueChange = {
                text = it
            },
            label = { Text(text = "Email address") },
            placeholder = { Text(text = "Enter your e-mail") },
        )

        // TextField InputType Password
        OutlinedTextField(
            value = text, onValueChange = {
                text = it
            },
            label = { Text(text = "Password", color = Color.Red) },
            placeholder = { Text(text = "Enter Password") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image =
                    if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description = if (passwordVisible) "Hide password" else "Show password"
                // tạo icon để khi bấm có thể hiển thị pass hoặc ẩn pass
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, description)
                }
            }
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.fillMaxWidth().background(Color.Red),
            textAlign = TextAlign.Center,
            color = Color.Blue,

        )
        Spacer(modifier = Modifier.height(height = 20.dp))
        Text(
            text = "Hello $name!",
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                .background(Color.Yellow).padding(top = 10.dp),
            fontFamily = FontFamily.Monospace,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,

        )
    }
} // sử dung textview trong jetpack compose

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    UseJetpackComposeTheme {
//        Greeting(name = "Huychu")
//        TextFiled1()
        ButtonView()
    }
}
