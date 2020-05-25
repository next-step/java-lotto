package calculator;

import calculator.domain.Numbers;
import calculator.domain.StringAddCalculator;
import calculator.domain.StringParser;
import calculator.view.InputView;
import calculator.view.ResultView;

public class Main {

    public static void main(String[] args) {
        String userInput = InputView.getUserInput();

        Numbers numbers = new Numbers(StringParser.parseString(userInput));
        Integer calculationResult = StringAddCalculator.getNumbersSum(numbers);

        ResultView.printResult(calculationResult);
    }
}
