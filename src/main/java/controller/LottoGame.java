package controller;

import domain.LottoResult;
import domain.Lottos;
import view.ConsoleInputView;
import view.ConsoleOutputView;
import view.InputView;
import view.OutputView;

public class LottoGame {
    private static final int PRICE_OF_LOTTO = 1_000;

    private LottoGame() {

    }

    public static void run() {
        InputView inputView = new ConsoleInputView();
        inputView.showPurchaseAmountInputMessage();
        int purchaseAmount = inputView.extractPurchaseAmount();

        OutputView outputView = new ConsoleOutputView();
        outputView.showTotalNumberOfLottos(purchaseAmount/PRICE_OF_LOTTO);
        outputView.showRandomGeneratedLottos(new Lottos());

        inputView.showWinningNumberInputMessage();
        String winningNumber = inputView.extractWinningNumber();

        outputView.showLottoResult(new LottoResult());
        outputView.showProfitRate(0.0);
    }
}
