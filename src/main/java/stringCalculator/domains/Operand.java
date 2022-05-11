package stringCalculator.domains;

public class Operand {
    private final int number;

    public Operand(String number) {
        this.number = Integer.parseInt(number);
    }

    public int getInt() {
        return this.number;
    }
}
