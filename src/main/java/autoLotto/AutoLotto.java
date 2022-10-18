package autoLotto;

import static autoLotto.Match.*;

public class AutoLotto {

    public static void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Calculator calculator = new Calculator();
        Lottos lottos = new Lottos();
        Quantity quantity = new Quantity(inputView.inputAmount());

        int countOfLotto = quantity.getQuantity();
        outputView.outputQuantity(countOfLotto);

        for ( int i = 0 ; i < countOfLotto ; i++) {
            lottos.addLotto(new Lotto());
        }

        outputView.outputLottos(lottos);
        double result = calculator.calculate(lottos, new WinningNumbers(inputView.inputNumbers()),
                countOfLotto * 1000);
        outputView.outputResult(result, THREE.getCountOfMatch(), FOUR.getCountOfMatch(),
                FIVE.getCountOfMatch(), SIX.getCountOfMatch());
    }
}
