package marquez.emiliano.thecheezery.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(innerPadding: PaddingValues, onLogin: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var submitted by remember { mutableStateOf(false) }
    val validEmail = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    Column(Modifier.fillMaxSize().padding(24.dp), Arrangement.Center) {
        Text("Login", style = MaterialTheme.typography.headlineLarge)
        OutlinedTextField(email, { email = it }, Modifier.fillMaxWidth(), label = { Text("Email") },
            isError = submitted && !validEmail, supportingText = {
                if (submitted && email.isBlank()) Text("Email is required")
                else if (submitted && !validEmail) Text("Enter a valid email")
            })
        OutlinedTextField(password, { password = it }, Modifier.fillMaxWidth(), label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(), isError = submitted && password.isBlank(),
            supportingText = { if (submitted && password.isBlank()) Text("Password is required") })
        Button(onClick = { submitted = true; if (validEmail && password.isNotBlank()) onLogin() }) {
            Text("LOGIN")
        }
    }
}
