package StringCalculator;

public class Value {
    private final Integer value;

    public Value(Integer integer) {
        this.value = integer;
    }

    public Integer add(Integer integer) {
        return this.value + integer;
    }

    public Integer subtract(Integer integer) {
        return this.value - integer;
    }

    public Integer multiply(Integer integer) {
        return this.value * integer;
    }

    public Integer divide(Integer integer) {
        return this.value / integer;
    }
}
