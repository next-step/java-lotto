package lotto.step2.util;

import lotto.step2.domain.Lotto;
import lotto.step2.domain.WinnerNumbers;
import lotto.step2.input.InputView;
import lotto.step2.input.UserInput;
import lotto.step2.result.ResultView;

import java.util.List;

public class LottoProgram {
    public static final int LOTTO_PRICE = 1000;

    public static void start() {
        final UserInput input = InputView.inputPurchaseAmount();
        final int numberOfLottos = LottoProgramManager.calculateNumberOfLottos(input.getPurchaseAmount(), LOTTO_PRICE);

        List<Lotto> lottos = LottoProgramManager.generateLottos(numberOfLottos);
        ResultView.printLottos(lottos);

        final WinnerNumbers winnerNumbers = InputView.inputWinnersNumbers();
    }
}
