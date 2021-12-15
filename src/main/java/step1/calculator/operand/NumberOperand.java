package step1.calculator.operand;

public class NumberOperand {
    private final int operand;

    private NumberOperand(int operand) {
        validateNegative(operand);
        this.operand = operand;
    }

    private static void validateNegative(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 입력될 수 없습니다.");
        }
    }

    public static NumberOperand from(int input) {
        return new NumberOperand(input);
    }

    public static NumberOperand from(String input) {
        int number = parseInt(input);
        return new NumberOperand(number);
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException("알맞은 문자열 포맷이 아닙니다.");
        }
    }

    public int plus(int number) {
        return operand + number;
    }

}
