import KMMViewModelSwiftUI
import SwiftUI
import shared

struct RootScreen: View {
    @StateViewModel var viewModel = RootViewModel()
    var body: some View {
        Button("Load") {
            viewModel.load()
        }

        Divider()

        ForEach(viewModel.groups, id: \.name) { group in
            GroupView(name: group.name, viewModels: group.groupItemViewModels)
        }
    }
}

struct GroupView: View {
    let name: String
    let viewModels: [GroupItemViewModel]
    @State private var isExpanded: Bool = true

    var body: some View {
        HStack {
            Text(name)
            Button(action: {
                isExpanded.toggle()
            }, label: {
                Image(systemName: isExpanded ? "chevron.up" : "chevron.down")
            })
        }
        if (isExpanded) {
            ForEach(viewModels, id: \.name) { groupItemViewModel in
                GroupItemView(groupItemViewModel)
            }
        }
        Divider()
    }
}

struct GroupItemView: View {
    @ObservedViewModel var viewModel: GroupItemViewModel

    init(_ viewModel: GroupItemViewModel) {
        _viewModel = ObservedViewModel(wrappedValue: viewModel)
    }

    var body: some View {
        Text(viewModel.name)
    }
}
