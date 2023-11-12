package step1;

public enum Operator {
    PLUS('+');

    private char symbol;

    Operator(char symbol) {
        this.symbol = symbol;
    }

    public static Operator findOperatorByUserInput(char symbol) {
        for (Operator op : values()) {
            if (op.symbol == symbol) {
                return op;
            }
        }
        throw new IllegalArgumentException("사칙연사의 기호가 아닙니다");
    }
}
