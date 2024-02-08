package com.ys.composeplayground.ui.sample.photoapp.profile

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ys.composeplayground.ui.sample.photoapp.Photographer

@Composable
fun Profile(photographer: Photographer, modifier: Modifier = Modifier) {
    val padding = 16.dp
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.onSurface,
        contentColor = MaterialTheme.colorScheme.surface,
    ) {
        TutorialOverlay { tutorialHighlightModifier ->
            Column(Modifier.padding(top = 24.dp)) {
                Spacer(modifier = Modifier.weight(1f))
                ProfileHeader(
                    photographer = photographer,
                    tutorialHighlightModifier = tutorialHighlightModifier
                )
                Spacer(modifier = Modifier.weight(1f))
                TagList(
                    tags = photographer.tags,
                    modifier = Modifier.padding(vertical = padding)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "PortfolioCard")
            }
        }
    }
}

@Composable
private fun TagList(tags: List<String>, modifier: Modifier = Modifier) {
    val padding = 8.dp
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(start = padding * 2, end = padding),
        horizontalArrangement = Arrangement.spacedBy(padding),
    ) {
        items(tags) {
            Text(
                text = it,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
                        shape = CircleShape
                    )
                    .padding(padding)
            )
        }
    }
}