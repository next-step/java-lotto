package stringcalculator;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

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
        throw new IllegalArgumentException("유효하지 않은 연산자 입니다");
    }

}