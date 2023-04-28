package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Expression {
    private static final String INPUT_FORMAT = "^[0-9]+([-|+|*|/]{1}[0-9]*)+[0-9]+$";
    private static final String NUMBERS_REGEX = "[0-9]+";
    private static final String OPERATIONS_REGEX = "[-|+|*|/]{1}";
    private static final String SPACE = " ";
    private static final String BLANK = "";

    private final String expression;

    public Expression(String input) {
        this.expression = validate(input);
    }

    private String validate(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값이 빈칸입니다.");
        }

        String inputWithoutSpace = input.replaceAll(SPACE, BLANK);
        if (!inputWithoutSpace.matches(INPUT_FORMAT)) {
            throw new IllegalArgumentException("입력 형식에 맞지 않습니다.");
        }

        return input;
    }

    public List<Integer> getNumbers() {
        List<String> elements = split();

        return elements.stream()
                .filter(element -> isNumber(element))
                .mapToInt(element -> Integer.parseInt(element))
                .boxed()
                .collect(Collectors.toList());
    }

    private boolean isNumber(String element) {
        return element.matches(NUMBERS_REGEX);
    }

    public List<OperationStrategy> getOperations() {
        List<String> elements = split();

        return elements.stream()
                .filter(element -> isOperation(element))
                .map(element -> Operation.getOperationStrategy(element))
                .collect(Collectors.toList());
    }

    private boolean isOperation(String element) {
        return element.matches(OPERATIONS_REGEX);
    }

    private List<String> split() {
        return Arrays.asList(expression.split(SPACE));
    }
}
