import java.util.Objects;

public final class Operand {

    private final int value;

    private Operand(final int value) {
        this.value = value;
    }

    public int intValue() {
        return value;
    }

    public Operand plus(final Operand other) {
        return Operand.valueOf(value + other.value);
    }

    public Operand minus(final Operand other) {
        return Operand.valueOf(value - other.value);
    }

    public Operand times(final Operand other) {
        return Operand.valueOf(value * other.value);
    }

    public Operand divide(final Operand other) {
        return Operand.valueOf(value / other.value);
    }

    public static Operand valueOf(final int value) {
        return new Operand(value);
    }

    public static Operand valueOf(final String value) {
        return new Operand(Integer.parseInt(value));
    }

    public static boolean canParseOperand(final String value) {
        try {
            Operand.valueOf(value);
            return true;
        } catch (final NumberFormatException numberFormatException) {
            return false;
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Operand operand = (Operand) o;
        return value == operand.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
