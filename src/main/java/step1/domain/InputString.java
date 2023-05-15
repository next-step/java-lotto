package step1.domain;

public class InputString {
    private static final String EXPRESSION_REGEX = "^\\d+(\\s*[+\\-*/]\\s*\\d+)*$";

    public InputString(String value) {
        if (value == null || !value.matches(EXPRESSION_REGEX)) {
            throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
        }
    }

}
