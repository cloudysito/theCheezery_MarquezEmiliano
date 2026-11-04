package marquez.emiliano.thecheezery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import marquez.emiliano.thecheezery.navigation.TheCheezeryNavHost
import marquez.emiliano.thecheezery.ui.theme.TheCheezeryTheme
import marquez.emiliano.thecheezery.viewmodel.CheezeryViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: CheezeryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheCheezeryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TheCheezeryNavHost(innerPadding, viewModel)
                }
            }
        }
    }
}
