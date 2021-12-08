package controller;

import domain.*;
import view.ConsoleInputView;
import view.ConsoleOutputView;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

import static util.StringUtils.parseNumbers;

public class LottoGame {

    private static final int START_INDEX_MANUAL_LOTTO_NUMBERS = 0;

    private LottoGame() {

    }

    public static void run() {
        InputView inputView = new ConsoleInputView();
        inputView.showPurchaseAmountInputMessage();
        LottoPurchaseAmount lottoPurchaseAmount = LottoPurchaseAmount.of(inputView.purchaseAmount());

        inputView.showManualPurchaseAmountInputMessage();
        int manualPurchaseAmount = inputView.manualPurchaseAmount();
        int totalNumberOfLottos = lottoPurchaseAmount.amount();
        Lottos lottos = Lottos.of(totalNumberOfLottos - manualPurchaseAmount);

        inputView.showManualLottoInputMessage();
        IntStream.range(START_INDEX_MANUAL_LOTTO_NUMBERS, manualPurchaseAmount)
                .forEach(i -> {
                    List<Integer> manualLottoNumbers = inputView.manualLottoNumbers();
                    lottos.add(manualLottoNumbers);
                });

        OutputView outputView = new ConsoleOutputView();
        outputView.showTotalNumberOfLottos(totalNumberOfLottos);
        outputView.showRandomGeneratedLottos(lottos);

        inputView.showWinningNumberInputMessage();
        String winningNumber = inputView.winningNumber();
        Lotto winningLotto = Lotto.of(parseNumbers(winningNumber));

        inputView.showBonusBallInputMessage();
        int bonusNumber = inputView.bonusBall();

        Prizes prizes = lottos.prizes(winningLotto, new LottoNumber(bonusNumber));
        double profitRate = prizes.profitRate(lottoPurchaseAmount);
        outputView.showLottoResult(prizes);
        outputView.showProfitRate(profitRate);
    }
}
