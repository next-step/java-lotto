package step1.domain;

public class Operand {
    private final int number;

    private Operand(String number) {
        this.number = Integer.parseInt(number);
    }

    public static Operand from(String input) {
        try {
            return new Operand(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닙니다: " + input);
        }
    }

    public int getOperand() {
        return number;
    }

}
