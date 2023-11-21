package domain;

import io.InputView;
import io.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        Calculator calculator = new Calculator(inputView.input);
        calculator.init();

        OutputView outputView = new OutputView(calculator.inputList);

    }
}
