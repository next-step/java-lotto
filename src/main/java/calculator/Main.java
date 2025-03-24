package calculator;

import calculator.domain.Calculator;
import calculator.domain.Extractor;
import calculator.domain.Number;
import calculator.domain.Operator;
import calculator.view.InputView;
import calculator.view.ResultView;

import java.util.List;

public class Main {
    public static Number run(String input) {
        List<Number> numbers = Extractor.extract_numbers(input);
        List<Operator> operators = Extractor.extract_operators(input);
        checkInputSize(numbers, operators);
        return calculate(numbers, operators);
    }

    private static void checkInputSize(List<Number> numbers, List<Operator> operators) {
        if (numbers.size() != operators.size() + 1) {
            throw new IllegalArgumentException();
        }
    }

    private static Number calculate(List<Number> numbers, List<Operator> operators) {
        Number result = numbers.get(0);
        for (int i=0; i<operators.size(); i++) {
            result = Calculator.run(result, numbers.get(i+1), operators.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        String input = InputView.start();
        Number output = run(input);
        ResultView.printResult(output);
    }
}
