

package com.example.customlazycolumn

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.security.identity.AccessControlProfile
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.customlazycolumn.data.Books
import com.example.customlazycolumn.ui.theme.CustomLazyColumnTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomLazyColumnTheme {
                // A surface container using the 'background' color from the theme

                   MyApp{
                       startActivity(ProfileActivity.newIntent(this, it))
                   }
                }
            }
        }
    }





@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(navigateToProfile: (Books) -> Unit)
{
    Scaffold (
        content = {
            CustomLazyColumnHomeContent(navigateToProfile = navigateToProfile)
        }
    )
}