package calculator.string;

import calculator.string.domain.Calculator;
import calculator.string.domain.StringCalculator;
import calculator.string.view.Input;
import calculator.string.view.Output;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Output.printInputMessage();
        String expression = Input.expressionInput();

        Calculator stringCalculator = new StringCalculator();
        stringCalculator.inputExpression(expression);
        int result = stringCalculator.calculation();

        Output.printResultMessage(result);
    }
}
