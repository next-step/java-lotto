package stringCalculator;

public class Value {
    private final int value;

    public Value(int integer) {
        this.value = integer;
    }

    public int add(int integer) {
        return this.value + integer;
    }

    public int subtract(int integer) {
        return this.value - integer;
    }

    public int multiply(int integer) {
        return this.value * integer;
    }

    public int divide(int integer) {
        return this.value / integer;
    }
}
