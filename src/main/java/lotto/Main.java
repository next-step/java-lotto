package lotto;

import lotto.domain.Calculator;
import lotto.domain.Extractor;
import lotto.domain.Operator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {
    private static long run(String input) {
        List<Long> numbers = Extractor.extract_numbers(input);
        List<Operator> operators = Extractor.extract_operators(input);
        checkInputSize(numbers, operators);
        return calculate(numbers, operators);
    }

    private static void checkInputSize(List<Long> numbers, List<Operator> operators) {
        if (numbers.size() != operators.size() + 1) {
            throw new IllegalArgumentException();
        }
    }

    private static long calculate(List<Long> numbers, List<Operator> operators) {
        long result = numbers.get(0);
        for (int i=0; i<operators.size(); i++) {
            result = Calculator.run(result, numbers.get(i+1), operators.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        String input = InputView.start();
        long output = run(input);
        ResultView.printResult(output);
    }
}
