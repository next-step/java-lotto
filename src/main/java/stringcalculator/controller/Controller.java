package stringcalculator.controller;

import stringcalculator.domain.Calculator;
import stringcalculator.ui.InputView;
import stringcalculator.ui.ResultView;

public class Controller {
    public static void main(String[] args) {
        try {
            int result = new Calculator(InputView.inputFormula()).calculate();
            ResultView.printResult(result);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage().replaceFirst("For input string: \"[-*/+]\"", "수식의 순서가 잘못되었습니다."));
        }
    }
}
