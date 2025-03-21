package tutorial;

import tutorial.calculator.CalculatorFactory;

import java.util.List;

import static tutorial.view.InputView.inputExpression;
import static tutorial.view.ResultView.printResult;

public class StringCalculator {
    public static void main(String[] args) {
        printResult(calculate(inputExpression()));
    }

    public static int calculate(String input) {
        List<String> inputList = List.of(input.split(" "));
        int result = Integer.parseInt(inputList.get(0));
        CalculatorFactory calculatorFactory = new CalculatorFactory();
        for (int i = 1; i < inputList.size(); i += 2) {
            result = calculatorFactory.getCalculator(inputList.get(i)).calculate(result, Integer.parseInt(inputList.get(i + 1)));
        }
        return result;
    }
}
