package lotto.view.fake;


import lotto.view.input.BaseInputView;

public class FakeInputView extends BaseInputView {

    private final String input;

    public FakeInputView(String input) {
        this.input = input;
    }

    @Override
    public String read() {
        return input.trim();
    }

    @Override
    public void closeScanner() {}

    public Integer parseInt() {
        return Integer.parseInt(this.input);
    }
}
