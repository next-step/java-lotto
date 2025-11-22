package calculate.domain;

public class Expression {
    private final String value;

    public Expression(String value) {
        validate();
        expressionValidate();
        this.value = value;
    }

    private void validate() {
        if (isNullOrEmpty()) {
            throw new IllegalArgumentException("입력값은 null이거나 빈 공백일 수 없다");
        }
    }

    private boolean isNullOrEmpty() {
        return value == null || value.isEmpty();
    }

    private void expressionValidate() {
        if(value.matches("[0-9+\\-*/\\s]+")) {
            return;
        }

        throw new IllegalArgumentException("입력값은 숫자나 사칙연산 기호만 가능하다.");
    }




}

