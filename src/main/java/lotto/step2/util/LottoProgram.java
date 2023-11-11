package lotto.step2.util;

import lotto.step2.input.InputView;
import lotto.step2.input.UserInput;

public class LottoProgram {
    public static final int LOTTO_PRICE = 1000;

    public static void start() {
        final UserInput input = InputView.input();
        final int numberOfLottos = LottoProgramManager.calculateNumberOfLottos(input.getPurchaseAmount(), LOTTO_PRICE);
    }
}
