package lotto.step2.service;

import lotto.step2.domain.Lotto;
import lotto.step2.domain.LottoGenerator;
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
        final UserInput input = InputView.input();

        List<Lotto> lottos = LottoGenerator.generateLottos(input);
        ResultView.printLottos(lottos, input.getPassiveLottoCount());

        final WinnerNumbers winnerNumbers = InputView.inputWinnersNumbers();
        final LottoResults lottoResults = LottoResults.calculateResults(lottos, winnerNumbers);
        ResultView.printLottoResults(lottoResults);

        final double rateOfReturn = lottoResults.calculateRateOfReturn(input.getPurchaseAmount());
        ResultView.printRateOfReturn(rateOfReturn);
    }
}
