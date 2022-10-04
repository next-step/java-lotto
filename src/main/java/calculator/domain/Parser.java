package calculator.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Parser {
    public static List<Integer> parseOperand(List<String> elementsOfExpression) {
        return IntStream.range(0, elementsOfExpression.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> Integer.parseInt(elementsOfExpression.get(i)))
                .collect(Collectors.toList());
    }

    public static List<String> parseOperator(List<String> elementsOfExpression) {
        return IntStream.range(0, elementsOfExpression.size())
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> elementsOfExpression.get(i))
                .collect(Collectors.toList());
    }
}
