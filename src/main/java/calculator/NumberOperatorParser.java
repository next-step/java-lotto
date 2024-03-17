package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class NumberOperatorParser {

    public static final String SPLIT_DELIMITER = " ";
    private final List<String> numbers = new ArrayList<>();
    private final List<String> operators = new ArrayList<>();

    public NumberOperatorParser(String input) {
        parseInput(input);
    }

    public Numbers getNumbers() {
        return new Numbers(numbers);
    }

    public Operators getOperators() {
        return new Operators(operators);
    }

    private void parseInput(String input) {
        String[] inputs = input.split(SPLIT_DELIMITER);

        validateMatchCountNumbersAndOperators(inputs);

        parseNumber(inputs);
        parseOperator(inputs);
    }

    private static void validateMatchCountNumbersAndOperators(String[] inputs) {
        if ((inputs.length % 2) == 0) {
            throw new IllegalArgumentException("숫자와 연산자의 수가 매칭되지 않습니다.");
        }
    }

    private void parseNumber(String[] inputs) {
        IntStream.range(0, inputs.length)
                .filter(NumberOperatorParser::isEven)
                .forEach(index -> numbers.add(inputs[index]));
    }

    private static boolean isEven(int index) {
        return index % 2 == 0;
    }

    private void parseOperator(String[] inputs) {
        IntStream.range(0, inputs.length)
                .filter(NumberOperatorParser::isOdd)
                .forEach(index -> operators.add(inputs[index]));
    }

    private static boolean isOdd(int index) {
        return index % 2 == 1;
    }
}
