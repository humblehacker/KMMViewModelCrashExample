import KMMViewModelSwiftUI
import SwiftUI
import shared

struct RootScreen: View {
    @StateViewModel var viewModel = RootViewModel()
    var body: some View {
        TextField("text", text: $viewModel.text, prompt: Text("text"))
            .padding()
    }
}
