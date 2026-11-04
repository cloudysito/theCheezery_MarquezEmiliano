package marquez.emiliano.thecheezery.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import marquez.emiliano.thecheezery.R

@Composable
fun WelcomeScreen(innerPadding: PaddingValues, onStart: () -> Unit) {
    Column(Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally) {
        Image(painterResource(R.drawable.the_cheezery), "The Cheezery", Modifier.size(220.dp))
        Text("Welcome to\nthe Cheezery", style = MaterialTheme.typography.headlineLarge)
        Text("Fresh drinks, sweets and salty favorites")
        Button(onClick = onStart) { Text("START ORDER") }
    }
}
