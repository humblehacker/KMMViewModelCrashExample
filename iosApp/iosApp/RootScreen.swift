import KMMViewModelSwiftUI
import SwiftUI
import shared

struct RootScreen: View {
    @StateViewModel var viewModel = RootViewModel()
    @State private var isExpanded: Bool = true

    var body: some View {
        HStack {
            Button(
                action: { isExpanded.toggle() },
                label: { Image(systemName: isExpanded ? "chevron.right" : "chevron.left") }
            )

            if (isExpanded) {
                ChildView(viewModel: viewModel.childViewModel)
            }

            Spacer()
        }
        .padding()
    }
}

struct ChildView: View {
    @ObservedViewModel var viewModel: ChildViewModel

    init(viewModel: ChildViewModel) {
        _viewModel = ObservedViewModel(wrappedValue: viewModel)
    }

    var body: some View {
        Text(viewModel.name)
    }
}
