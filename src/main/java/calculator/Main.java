package calculator;

import calculator.domain.Calculator;

import static calculator.view.InputView.*;
import static calculator.view.ResultView.*;

public class Main {

    public static void main(String[] args) {
        printStart();
        String input = stringInput();

        int result = Calculator.calculate(input);

        printResult(result);
    }
}
