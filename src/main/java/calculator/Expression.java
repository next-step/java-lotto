package calculator;

public class Expression {
    public static final String CRITERIA = " ";
    public static final String REGEX = "^(-?\\d+|[+\\-*/])$";
    private final String[] value;

    public Expression(String value) {
        validateExpression(value);
        this.value = parsedNumber(value);
    }

    private void validateExpression(String value) {
        validateNull(value);
        validateBlank(value);
    }

    private void validateNull(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }
    }

    private void validateBlank(String expression) {
        if (expression.isBlank()) {
            throw new IllegalArgumentException("입력값이 공백입니다.");
        }
    }

    public int size() {
        return value.length;
    }

    public String firstValue() {
        return value[0];
    }

    public String get(int index) {
        return value[index];
    }

    public String[] parsedNumber(String value) {
        String[] paredNumber = value.split(CRITERIA);
        validateNumbers(paredNumber);
        return paredNumber;
    }

    private void validateNumbers(String[] paredNumber) {
        for (String element : paredNumber) {
            validateEachElement(element);
        }
    }

    private void validateEachElement(String element) {
        if (!element.matches(REGEX)) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}
