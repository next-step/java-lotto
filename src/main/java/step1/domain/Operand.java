package step1.domain;

public class Operand {
    private final int number;

    private Operand(int number) {
        this.number = number;
    }

    public static Operand from(String input) {
        try {
            return new Operand(toInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닙니다: " + input);
        }
    }

    private static int toInt(String stringNum) {
        return Integer.parseInt(stringNum);
    }

    public int getOperand() {
        return number;
    }

}
