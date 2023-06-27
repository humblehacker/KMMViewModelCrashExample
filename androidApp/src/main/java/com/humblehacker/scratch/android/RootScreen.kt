package com.humblehacker.scratch.android

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.humblehacker.scratch.RootViewModel

@Composable
fun RootScreen() {
    val viewModel = RootViewModel()

    val text by viewModel.text.collectAsStateWithLifecycle()

    Text(text)
}
