package com.humblehacker.scratch

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.flow.MutableStateFlow

open class RootViewModel : KMMViewModel() {
    @Suppress("Unused")
    @NativeCoroutinesState
    val text: MutableStateFlow<String> = MutableStateFlow(viewModelScope, "Hello World!")
}
