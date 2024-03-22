package domain;

import static config.CalculatorExceptionMessage.OPERAND_SHOULD_BE_INTEGER_FORMAT;

public class Operand {

    private final int number;

    private Operand(final int number) {
        this.number = number;
    }

    public int number() {
        return this.number;
    }

    public static Operand from(final String number) {
        try {
            return new Operand(Integer.parseInt(number));
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(OPERAND_SHOULD_BE_INTEGER_FORMAT.message(number));
        }
    }
}
