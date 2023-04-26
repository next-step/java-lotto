package calculator;

public class Operand {
    private final int value;

    private Operand(int value) {
        this.value = value;
    }

    public static Operand create(int value) {
        return new Operand(value);
    }

    public static Operand create(String value) {
        return new Operand(Integer.parseInt(value));
    }

    public int value() {
        return value;
    }
}
