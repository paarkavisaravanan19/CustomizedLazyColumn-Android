package com.example.customlazycolumn

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.customlazycolumn.data.Books

@Composable
fun ProfileScreen (books: Books) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints {
            Surface {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState))
                {
                    ProfileHeader(books = books, containerHeight = this@BoxWithConstraints.maxHeight)
                    ProfileContent(books = books, containerHeight = this@BoxWithConstraints.maxHeight)
                }
            }

        }
    }
}


@Composable
private fun ProfileHeader(
    books: Books,
    containerHeight: Dp
)
{
    Image(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth(),
        painter = painterResource(id = books.BookImageId),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Composable
private fun ProfileContent(books: Books,
                           containerHeight: Dp)
{
    Column {
        Title(books = books)
        ProfileProperty(label = stringResource(id = R.string.publishedyear), value =books.publishedyear.toString() )
        ProfileProperty(label = stringResource(id = R.string.author), value =books.author )
        ProfileProperty(label = stringResource(id = R.string.personality), value =books.description )
        Spacer(modifier = Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
    }

}

@Composable
private fun Title(books: Books) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = books.title,
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Bold
        )


    }
}



@Composable
private fun ProfileProperty (label: String, value: String)
{
    Column(modifier = Modifier.padding(start = 16.dp, end= 16.dp, bottom= 16.dp)) {

        Divider(modifier = Modifier.padding(bottom = 4.dp))
        Text(
            text = label,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = value,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.bodySmall,
            overflow = TextOverflow.Visible
        )
    }
}















