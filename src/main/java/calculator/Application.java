package calculator;

import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView.printRequestFormulaInput();
        StringCalculator stringCalculator = new StringCalculator(InputView.readFormula());
        System.out.println(stringCalculator.add());
    }
}
