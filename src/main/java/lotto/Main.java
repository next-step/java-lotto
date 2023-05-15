package lotto;

import lotto.domain.Lotto;
import lotto.view.InputView;

public class Main {
    static InputView inputView = new InputView();
    static Lotto lotto = new Lotto();
    public static void main(String[] args) {
        int lottoQuantity = lotto.lottoQuantity(inputView.inputCost());

    }

}
