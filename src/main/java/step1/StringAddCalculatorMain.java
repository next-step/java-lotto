package step1;


import step1.domain.InputString;
import step1.domain.calculator.StringAddCalculator;
import step1.domain.calculator.StringCalculator;

import static step1.view.InputView.inputString;
import static step1.view.OutputView.outputResultMessage;

public class StringAddCalculatorMain {

    public static void main(String[] args) {
        InputString inputString = new InputString(inputString());
        StringCalculator addCalculator = new StringAddCalculator();
        outputResultMessage(addCalculator.apply(inputString));
    }
}
