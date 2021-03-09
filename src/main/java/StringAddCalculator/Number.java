package StringAddCalculator;

public class Number {

    private final int value;

    public final static Number ZERO = new Number(0);

    public Number(int value) {
        if (value < 0) {
            throw new RuntimeException("not allowed number smaller than 0");
        }
        this.value = value;
    }

    public static Number valueOf(String valueInString) {
        try {
            return new Number(Integer.parseInt(valueInString));
        } catch (NumberFormatException ex) {
            throw new RuntimeException("not allowed value");
        }
    }

    public Number sum(Number number) {
        return new Number(this.value + number.toValue());
    }

    public int toValue() {
        return value;
    }


}
