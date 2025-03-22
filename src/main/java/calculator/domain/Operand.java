package calculator.domain;

public class Operand {
    private final Integer value;

    public Operand(Integer input) {
        this.value = input;
    }

    public Integer getValue() {
        return value;
    }

    public static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
