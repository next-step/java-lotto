package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Operand {
    static final String MESSAGE_OF_NOT_NUMBER_EXCEPTION = "피연산자는 숫자여야 합니다: ";
    static final String MESSAGE_OF_NEGATIVE_NUMBER_EXCEPTION = "피연산자는 0 또는 자연수여야 합니다.";

    static final int MINIMUM_VALUE = 0;
    private static final String REGEX_OF_NATURAL_NUMBER = "-?\\d+";

    private static final Map<Integer, Operand> CACHE = new HashMap<>();
    private int value;

    private Operand(int value) {
        this.value = value;
    }

    static Operand of(int value) {
        validateOperandIsPositive(value);
        Operand operand = CACHE.getOrDefault(value, new Operand(value));
        CACHE.putIfAbsent(value, operand);
        return operand;
    }

    static Operand of(String value) {
        validateOperandIsNumber(value);
        int numberOfValue = Integer.parseInt(value);
        return Operand.of(numberOfValue);
    }

    private static void validateOperandIsNumber(String operand) {
        if (!operand.matches(REGEX_OF_NATURAL_NUMBER)) {
            StringBuilder exceptionMessage = new StringBuilder(MESSAGE_OF_NOT_NUMBER_EXCEPTION).append(operand);
            throw new IllegalArgumentException(String.valueOf(exceptionMessage));
        }
    }

    private static void validateOperandIsPositive(int operand) {
        if (operand < MINIMUM_VALUE) {
            StringBuilder exceptionMessage = new StringBuilder(MESSAGE_OF_NEGATIVE_NUMBER_EXCEPTION).append(operand);
            throw new IllegalArgumentException(String.valueOf(exceptionMessage));
        }
    }

    Operand add(Operand other) {
        return Operand.of(this.value + other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Operand)) return false;
        Operand operand = (Operand) o;
        return value == operand.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    int convert() {
        return value;
    }
}
