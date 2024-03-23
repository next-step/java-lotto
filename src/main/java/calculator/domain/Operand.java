package calculator.domain;

import static calculator.config.CalculatorExceptionMessage.OPERAND_SHOULD_BE_INTEGER_FORMAT;

import java.util.Objects;

class Operand implements Token {

    private final int number;

    Operand(final int number) {
        this.number = number;
    }

    int number() {
        return this.number;
    }

    static Operand from(final String number) {
        try {
            return new Operand(Integer.parseInt(number));
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(OPERAND_SHOULD_BE_INTEGER_FORMAT.message(number));
        }
    }

    @Override
    public boolean equals(final Object otherOperand) {
        if (this == otherOperand) {
            return true;
        }

        if (otherOperand == null || getClass() != otherOperand.getClass()) {
            return false;
        }

        return this.number == ((Operand)otherOperand).number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.number);
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }
}
