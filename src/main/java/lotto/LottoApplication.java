package lotto;

import lotto.domain.Calculator;
import lotto.view.InputView;

public class LottoApplication {
    private static InputView inputView;
    private static Calculator calculator;


    public static void main(String[] args) {
        System.out.println(Calculator.calculate(inputView.requestOperation()));
    }

}
