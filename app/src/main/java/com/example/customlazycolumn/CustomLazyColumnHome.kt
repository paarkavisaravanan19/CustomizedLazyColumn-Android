package com.example.customlazycolumn

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.customlazycolumn.data.Books
import com.example.customlazycolumn.data.DataProvider

@Composable
fun CustomLazyColumnHomeContent(navigateToProfile : (Books) -> Unit){
    val books = remember { DataProvider.booksList}
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ){
        items(
            items = books,
            itemContent = {
                BookListItems(book = it, navigateToProfile)
            }
        )
    }
}