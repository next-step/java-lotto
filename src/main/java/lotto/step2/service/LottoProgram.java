package lotto.step2.service;

import lotto.step2.domain.Lotto;
import lotto.step2.domain.LottoResults;
import lotto.step2.domain.WinnerNumbers;
import lotto.step2.input.InputView;
import lotto.step2.input.UserInput;
import lotto.step2.result.ResultView;

import java.util.List;

public class LottoProgram {
    public static final int LOTTO_PRICE = 1000;

    private LottoProgram() {
        throw new IllegalStateException("Service class");
    }

    public static void start() {
        final UserInput input = InputView.inputPurchaseAmount();
        final int purchaseAmount = input.getPurchaseAmount();
        final int numberOfLottos = LottoProgramManager.calculateNumberOfLottos(purchaseAmount, LOTTO_PRICE);

        List<Lotto> lottos = LottoProgramManager.generateLottos(numberOfLottos);
        ResultView.printLottos(lottos);

        final WinnerNumbers winnerNumbers = InputView.inputWinnersNumbers();
        final LottoResults lottoResults = winnerNumbers.matchLottos(lottos);
        ResultView.printLottoResults(lottoResults);

        final double rateOfReturn = lottoResults.calculateRateOfReturn(purchaseAmount);
        ResultView.printRateOfReturn(rateOfReturn);
    }
}
