package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Main {

    public static void main(String[] args) {
        int money = InputView.inputAmount();
        int lottoCount = Lotto.lottoCount(money);

        OutputView.lottoCount(lottoCount);
    }
}
