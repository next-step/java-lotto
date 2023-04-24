package step1.domain;

public class Expression {

    private static final String EXPRESSION_REGEX = "^\\d+(\\s*[+\\-*/]\\s*\\d+)*$";

    private String value;

    public Expression(String value) {
        if (isBlank(value) || !value.matches(EXPRESSION_REGEX)) {
            throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
        }
        this.value = value;
    }

    public boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    public String getValue() {
        return value;
    }

}
