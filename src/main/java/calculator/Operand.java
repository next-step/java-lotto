package calculator;

public class Operand {

    public static final Operand ZERO = new Operand("0");

    private static final String VALID_REGEX = "[0-9]+";

    private final int value;

    public Operand(int value) {
        validate(value);
        this.value = value;
    }

    public Operand(String stringNumber) {
        validate(stringNumber);
        this.value = Integer.parseInt(stringNumber);
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("피연산자는 0 이상의 양수여야합니다.");
        }
    }

    private void validate(String stringNumber) {
        if (!stringNumber.matches(VALID_REGEX)) {
            throw new IllegalArgumentException("피연산자는 0 이상의 양수여야합니다.");
        }
    }

    public Operand add(final Operand other) {
        return new Operand(value + other.value);
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operand operand = (Operand) o;

        return value == operand.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

}
