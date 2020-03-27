package lotto;

import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        InputView inputView = new InputView();

        int lotteryCount = lotto.buy(inputView.inputPrice());
        OutputView.printLotteryCount(lotteryCount);
    }
}
