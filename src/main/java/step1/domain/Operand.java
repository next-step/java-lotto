package step1.domain;

public class Operand {
    private final int operand;

    public Operand(int operand) {
        this.operand = operand;
    }

    public int getValue() {
        return operand;
    }

    public static Operand of(int operand) {
        return new Operand(operand);
    }
}
