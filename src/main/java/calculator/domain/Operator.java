package calculator.domain;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String name;

    Operator(String name) {
        this.name = name;
    }

    public static Operator fromName(String name) {
        for (Operator operator : values()) {
            if (operator.name.equals(name)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
    }
}
