package lotto;

import lotto.dto.Price;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Price price = inputView.inputPrice();
    }
}
