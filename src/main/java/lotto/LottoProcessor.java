package lotto;

import lotto.domain.UserInput;
import lotto.view.InputView;

public class LottoProcessor {

    static InputView inputView = new InputView();

    public static void main(String[] args) {
        int price = Integer.parseInt(inputView.getPrice());
        UserInput userInput = new UserInput(price);
    }
}
