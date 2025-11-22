package calculate.domain;

public class Expression {
    public static final String SPLIT_REGEX = " ";
    public static final String REGEX = "[0-9+\\-*/\\s]+";
    private final String value;

    public Expression(String value) {
        validate(value);
        expressionValidate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (isNullOrEmpty(value)) {
            throw new IllegalArgumentException("입력값은 null이거나 빈 공백일 수 없다");
        }
    }

    private boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }

    private void expressionValidate(String value) {
        if(value.matches(REGEX)) {
            return;
        }

        throw new IllegalArgumentException("입력값은 숫자나 사칙연산 기호만 가능하다.");
    }

    public String[] split() {
        return value.split(SPLIT_REGEX);
    }




}

