package calculator;

public class StringAdditionCalculator {
    private static final String NOT_VALID_ARGUMENT_EXIST_STATEMENT = "음수 또는 숫자이외 값이 존재합니다";

    public String[] splitWithCommaOrColon(String expression) {
        return expression.split(",|:");
    }
}
