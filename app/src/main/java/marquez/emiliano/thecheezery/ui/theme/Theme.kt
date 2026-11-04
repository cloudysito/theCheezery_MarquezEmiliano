package marquez.emiliano.thecheezery.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import marquez.emiliano.thecheezery.R

private val LightColorScheme = lightColorScheme(
    primary = VeryPurple,
    secondary = LessPurple,
    tertiary = Pinky,
    background = DustyWhite,
    surface = DustyWhite
)

val HelloBunny = FontFamily(Font(R.font.hello_bunny))

val Typography = androidx.compose.material3.Typography(
    headlineLarge = TextStyle(fontFamily = HelloBunny, fontSize = 42.sp, color = Pinky),
    headlineMedium = TextStyle(fontFamily = HelloBunny, fontSize = 36.sp, color = Pinky),
    bodyLarge = TextStyle(fontSize = 20.sp),
    labelLarge = TextStyle(fontWeight = FontWeight.Bold)
)

@Composable
fun TheCheezeryTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = LightColorScheme, typography = Typography, content = content)
}
