package calculator;

public class Operator {
    private final String value;

    public Operator(String input) {
        checkSupportedOperator(input);
        this.value = input;
    }

    public static void checkSupportedOperator(String operator) {
        String[] supportedOperators = {"+", "-", "*", "/"};
        for (String supportedOperator : supportedOperators) {
            if (supportedOperator.equals(operator)) {
                return;
            }
        }

        throw new IllegalArgumentException("지원하지 않는 연산자 입니다. 입력 연산자:" + operator);
    }

    public String getValue() {
        return value;
    }
}
