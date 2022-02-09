package calculator;

import calculator.domain.StringCalculator;
import calculator.view.InputView;

public class Application {

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        System.out.println(stringCalculator.add(InputView.readFormula()));
    }
}
