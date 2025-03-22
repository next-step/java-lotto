package calculator.domain;

public class Operator {
    private final String value;

    public Operator(String input) {
        if (!isSupportedOperator(input)) {
            throw new IllegalArgumentException("지원하지 않는 연산자 입니다. 입력 연산자:" + input);
        }

        this.value = input;
    }

    public static boolean isSupportedOperator(String operator) {
        String[] supportedOperators = {"+", "-", "*", "/"};
        for (String supportedOperator : supportedOperators) {
            if (supportedOperator.equals(operator)) {
                return true;
            }
        }

        return false;
    }

    public String getValue() {
        return value;
    }
}
