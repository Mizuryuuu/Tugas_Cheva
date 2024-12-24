package com.bijana.doms.tugas2_cheva

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bijana.doms.tugas2_cheva.ui.theme.Tugas2_ChevaTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tugas2_ChevaTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = stringResource(R.string.app_name))
                            },
                            colors = TopAppBarDefaults.mediumTopAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        )
                    }) { innerPadding ->
                    EpisodeList(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun EpisodeList(modifier: Modifier) {
    val episodes = listOf(
        Episode(R.drawable.testcover, "Chapter 1", "07/07/2014"),
        Episode(R.drawable.testcover, "Chapter 2", "14/07/2014"),
        Episode(R.drawable.testcover, "Chapter 3", "21/07/2014"),
        Episode(R.drawable.testcover, "Chapter 4", "28/07/2014"),
    )

    LazyColumn (modifier.fillMaxSize()) {
        items(episodes.size) { index ->
            EpisodeItem(episode = episodes[index])
        }
    }
}

@Composable
fun EpisodeItem(episode: Episode) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = episode.imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .padding(end = 8.dp),
            contentScale = ContentScale.Crop
        )
        Column {
            Text(text = episode.title, fontSize = 16.sp)
            Text(text = episode.date, fontSize = 14.sp)
        }
    }
}

data class Episode(val imageRes: Int, val title: String, val date: String)