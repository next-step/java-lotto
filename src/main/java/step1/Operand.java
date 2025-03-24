package step1;

public class Operand {
    private final int value;

    public Operand(String input) {
        this.value = toInt(input);
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    public int getValue() {
        return this.value;
    }
}