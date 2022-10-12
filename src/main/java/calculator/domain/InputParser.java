package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputParser {

    private final static String SEPARATOR = " ";

    private final List<String> elementsOfExpression;

    public InputParser(String expression) {
        this.elementsOfExpression = Arrays.asList(expression.split(SEPARATOR));
    }

    public List<Integer> parseOperand() {
        return IntStream.range(0, elementsOfExpression.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> Integer.parseInt(elementsOfExpression.get(i)))
                .collect(Collectors.toList());
    }

    public List<String> parseOperator() {
        return IntStream.range(0, elementsOfExpression.size())
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> elementsOfExpression.get(i))
                .collect(Collectors.toList());
    }
}
