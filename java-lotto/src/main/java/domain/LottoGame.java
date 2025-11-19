package domain;


import ui.OutputView;
import ui.InputView;
import ui.StringCalculator;


public class LottoGame {

    public static void main(String[] args) {

        StringCalculator calculator = new StringCalculator(new InputView(), new OutputView());
        String input = "";
        input = calculator.inputView.getInput();
        calculator.inputView.validateInput(input);
        int result = calculator.calculate(input);
        calculator.outputView.printOutput(result);

    }
}
