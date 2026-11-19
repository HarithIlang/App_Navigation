package com.example.app_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.app_navigation.ui.theme.App_NavigationTheme

// The app's starting point. Its only job: open the app and show AppNav().
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App_NavigationTheme {
                AppNav()
            }
        }
    }
}
