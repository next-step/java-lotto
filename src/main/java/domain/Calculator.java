package domain;

import domain.symbol.Operand;
import views.InputView;
import views.ResultView;

public class Calculator {

    public static void main(String[] args) {
        Operand calculated = createCalculationWithQuery("수식을 입력하세요.").calculate();
        ResultView.printResult(calculated);
    }

    private static Calculation createCalculationWithQuery(String query) {
        Calculation calculation = null;
        while (calculation == null) {
            Tokens tokens = InputView.promptForTokens(query);
            calculation = getCalculation(tokens);
        }
        return calculation;
    }

    private static Calculation getCalculation(Tokens tokens) {
        try {
            return new Calculation(tokens);
        } catch (IllegalArgumentException e) {
            ResultView.printMessage("올바른 수식이 아닙니다.");
        }
        return null;
    }
}
