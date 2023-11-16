package calculator.domain;

public class Digit {
    private final int num;

    public Digit(String digit) {
        int num = Integer.parseInt(digit);
        this.num = num;
    }

    public static Digit of(String digit) {
        return new Digit(digit);
    }

    public int getNum() {
        return num;
    }
}
