package com.example.staggeredgalleryq1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.clickable
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.animation.core.animateDpAsState
import com.example.staggeredgalleryq1.ui.theme.StaggeredGalleryQ1Theme

data class Photo(val fileName: Int, val title: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StaggeredGalleryQ1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StaggeredGallery(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PicRender(photo: Photo) {
    val imagePainter = painterResource(id = photo.fileName)
    Image(
        painter = imagePainter,
        contentDescription = photo.title,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun StaggeredGallery(modifier: Modifier = Modifier) {
    val Photos = listOf(
        Photo(R.drawable.aero1, "Aero 1"),
        Photo(R.drawable.aero2, "Aero 2"),
        Photo(R.drawable.aero3, "Aero 3"),
        Photo(R.drawable.aero4, "Aero 4"),
        Photo(R.drawable.aero5, "Aero 5"),
        Photo(R.drawable.aero6, "Aero 6"),
        Photo(R.drawable.aero7, "Aero 7"),
        Photo(R.drawable.aero8, "Aero 8"),
        Photo(R.drawable.aero9, "Aero 9"),
        Photo(R.drawable.aero10, "Aero 10"),
        Photo(R.drawable.aero11, "Aero 11"),
        Photo(R.drawable.aero12, "Aero 12"),
        Photo(R.drawable.aero13, "Aero 13"),
        Photo(R.drawable.aero14, "Aero 14")
    )

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        content = {
            items(Photos.size) { index ->
                val photo = Photos[index]
                PicRender(photo)
            }
        },
        modifier = modifier.fillMaxSize()
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewStaggeredGallery() {
    StaggeredGalleryQ1Theme {
        StaggeredGallery()
    }
}
