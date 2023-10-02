package com.example.customlazycolumn

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.example.customlazycolumn.data.Books
import com.example.customlazycolumn.ui.theme.CustomLazyColumnTheme

class ProfileActivity : ComponentActivity() {
    private val books: Books by lazy {
        intent?.getSerializableExtra(BOOK_ID) as Books
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            CustomLazyColumnTheme {
                ProfileScreen(books = books)
            }
        }
    }

    companion object{
        private const val BOOK_ID = "book_id"
        fun newIntent(context: Context, books: Books ) =
            Intent(context, ProfileActivity::class.java).apply {
                putExtra(BOOK_ID, books)
            }
    }
}