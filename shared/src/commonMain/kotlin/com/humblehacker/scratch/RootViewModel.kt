package com.humblehacker.scratch

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.flow.MutableStateFlow

open class RootViewModel : KMMViewModel() {
    @NativeCoroutinesState
    val groups: MutableStateFlow<List<Group>> = MutableStateFlow(viewModelScope, emptyList())

    fun load() {
        groups.value = listOf(
            Group(
                "Group 1", listOf(
                    GroupItemViewModel("Item 1"),
                    GroupItemViewModel("Item 2"),
                    GroupItemViewModel("Item 3")
                )
            ),
            Group(
                "Group 2", listOf(
                    GroupItemViewModel("Item 1"),
                    GroupItemViewModel("Item 2"),
                    GroupItemViewModel("Item 3")
                )
            ),
            Group(
                "Group 3", listOf(
                    GroupItemViewModel("Item 1"),
                    GroupItemViewModel("Item 2"),
                    GroupItemViewModel("Item 3")
                )
            )
        )
    }
}

data class Group(
    val name: String,
    val groupItemViewModels: List<GroupItemViewModel>
)

open class GroupItemViewModel(name: String) : KMMViewModel() {
    @NativeCoroutinesState
    val name: MutableStateFlow<String> = MutableStateFlow(viewModelScope, name)
}
