package step1.domain;

public class Expression {

    private static final String EXPRESSION_REGEX  = "^\\d+(\\s*[+\\-*/]\\s*\\d+)*$";

    private String value;

    public Expression(String value) {
        if (!value.matches(EXPRESSION_REGEX)) {
            throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
        }
        this.value = value;
    }

}
