package com.humblehacker.scratch

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.flow.MutableStateFlow

open class RootViewModel : KMMViewModel() {
    @NativeCoroutinesState
    val childViewModel: MutableStateFlow<ChildViewModel> = MutableStateFlow(viewModelScope, ChildViewModel("Child"))
}

open class ChildViewModel(name: String) : KMMViewModel() {
    @NativeCoroutinesState
    val name: MutableStateFlow<String> = MutableStateFlow(viewModelScope, name)
}
