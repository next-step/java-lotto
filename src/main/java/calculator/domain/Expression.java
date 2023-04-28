package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class Expression {
    private static final String INPUT_FORMAT = "^[0-9]+([-|+|*|/]{1}[0-9]*)+[0-9]+$";
    public static final String SPACE = " ";
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

    public List<String> getElements() {
        return split();
    }

    private List<String> split() {
        return Arrays.asList(expression.split(SPACE));
    }
}
