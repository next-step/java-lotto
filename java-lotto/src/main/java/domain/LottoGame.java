package domain;


import ui.OutputView;
import ui.InputView;


public class LottoGame {

    public static void main(String[] args) {

        StringCalculator calculator = new StringCalculator(new InputView(), new OutputView());
        String input = "1 + 1";
        int result = calculator.calculate(input);
        calculator.outputView.printOutput(result);

    }
}
