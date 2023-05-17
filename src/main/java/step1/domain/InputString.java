package step1.domain;

public class InputString {
    private static final String EXPRESSION_REGEX = "^\\d+(\\s*[+\\-*/]\\s*\\d+)*$";

    private String text;

    public InputString(String text) {
        if (text == null || !text.matches(EXPRESSION_REGEX)) {
            throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
        }
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
