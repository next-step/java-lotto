package stringcalculator;


public class Input {

    private static final String NOT_CORRECT_INPUT = "올바른 형식의 문자열이 아닙니다";
    private static final String NEED_INPUT = "입력이 비었습니다. 계산할 문자열을 입력해주세요";
    private static final int MIN_LENGTH = 4;
    private final String[] value;

    public Input(String value) {
        validate(value);
        this.value = value.split(" ");
    }

    public String[] getValue() {
        return value;
    }

    private void validate(String source) {
        validate(isNotNull(source), NEED_INPUT);
        validate(isNotBlank(source), NEED_INPUT);
        validate(isUpperMinLength(source.length()), NOT_CORRECT_INPUT);
    }

    private void validate(boolean isValid, String validationMessage) {
        if (!isValid) {
            throw new IllegalArgumentException(validationMessage);
        }
    }

    private boolean isNotNull(Object source) {
        return source != null;
    }

    private boolean isNotBlank(String source) {
        return !source.isBlank();
    }

    private boolean isUpperMinLength(int length) {
        return length > MIN_LENGTH;
    }
}
