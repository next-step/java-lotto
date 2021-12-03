package controller;

import domain.Lotto;
import domain.Lottos;
import domain.Prizes;
import view.ConsoleInputView;
import view.ConsoleOutputView;
import view.InputView;
import view.OutputView;

import static util.StringUtils.parseNumbers;

public class LottoGame {

    private LottoGame() {

    }

    public static void run() {
        InputView inputView = new ConsoleInputView();
        inputView.showPurchaseAmountInputMessage();
        int purchaseAmount = inputView.extractPurchaseAmount();

        OutputView outputView = new ConsoleOutputView();
        int totalNumberOfLottos = Lotto.amount(purchaseAmount);
        Lottos lottos = Lottos.of(totalNumberOfLottos);

        outputView.showTotalNumberOfLottos(totalNumberOfLottos);
        outputView.showRandomGeneratedLottos(lottos);

        inputView.showWinningNumberInputMessage();
        String winningNumber = inputView.extractWinningNumber();
        Lotto winningLotto = Lotto.of(parseNumbers(winningNumber));

        Prizes prizes = new Prizes(lottos);
        double profitRate = prizes.profitRate(winningLotto);
        outputView.showLottoResult(prizes);
        outputView.showProfitRate(profitRate);
    }
}
