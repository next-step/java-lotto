package autoLotto;

import static autoLotto.Match.*;

public class AutoLotto {
    private static final int LOTTO_PRICE = 1000;

    public static void run() {
        Lottos lottos = new Lottos();
        Quantity quantity = new Quantity(InputView.inputAmount());

        int countOfLotto = quantity.getQuantity();
        OutputView.outputQuantity(countOfLotto);

        for ( int i = 0 ; i < countOfLotto ; i++) {
            lottos.addLotto(new Lotto());
        }

        OutputView.outputLottos(lottos);
        double result = Calculator.calculate(lottos, new WinningNumbers(InputView.inputNumbers()),
                countOfLotto * LOTTO_PRICE);
        OutputView.outputResult(result, THREE.getCountOfMatch(), FOUR.getCountOfMatch(),
                FIVE.getCountOfMatch(), SIX.getCountOfMatch());
    }
}
