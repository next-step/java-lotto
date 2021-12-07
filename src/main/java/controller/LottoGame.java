package controller;

import domain.Lotto;
import domain.LottoNumber;
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
        int purchaseAmount = inputView.purchaseAmount();

        inputView.showManualPurchaseAmountInputMessage();
        inputView.showManualLottoInputMessage();

        OutputView outputView = new ConsoleOutputView();
        int totalNumberOfLottos = Lotto.amount(purchaseAmount);
        Lottos lottos = Lottos.of(totalNumberOfLottos);

        outputView.showTotalNumberOfLottos(totalNumberOfLottos);
        outputView.showRandomGeneratedLottos(lottos);

        inputView.showWinningNumberInputMessage();
        String winningNumber = inputView.winningNumber();
        Lotto winningLotto = Lotto.of(parseNumbers(winningNumber));

        inputView.showBonusBallInputMessage();
        int bonusNumber = inputView.bonusBall();

        Prizes prizes = lottos.prizes(winningLotto, new LottoNumber(bonusNumber));
        double profitRate = prizes.profitRate(purchaseAmount);
        outputView.showLottoResult(prizes);
        outputView.showProfitRate(profitRate);
    }
}
