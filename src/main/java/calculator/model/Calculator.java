package calculator.model;

public class Calculator {

    private static final String DELIMITER = " ";
    private String[] expression;

    public Calculator(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException("입력값은 공백일 수 없습니다.");
        }
        this.expression = expression.split(DELIMITER);
    }
}
