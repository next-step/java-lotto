package lotto;

import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int price = inputView.inputPrice();
    }
}
