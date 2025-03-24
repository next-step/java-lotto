package StringCalculator.domain;

public class Operand {
    private final int value;

    public Operand(String value) {
        this(Integer.parseInt(value));
    }

    public Operand(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
