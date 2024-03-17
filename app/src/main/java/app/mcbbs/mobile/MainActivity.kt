package app.mcbbs.mobile

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import app.mcbbs.mobile.ui.theme.MCBBSTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MCBBSTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    WebViewContainer()
                }
            }
        }
    }
}

@Composable
fun WebViewContainer() {
    AndroidView(factory = { context ->
        val webView = WebView(context)
        webView.loadUrl("https://mcbbs.app")
        webView
    }, modifier = Modifier.fillMaxSize())
}

@Preview(showBackground = true)
@Composable
fun WebViewContainerPreview() {
    MCBBSTheme {
        WebViewContainer()
    }
}
