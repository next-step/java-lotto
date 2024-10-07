package stringcalculator;

import stringcalculator.view.InputView;
import stringcalculator.view.ResultView;

public class Application {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator(new InputView(), new ResultView());
        stringCalculator.run();
    }
}
