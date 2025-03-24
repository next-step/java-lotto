package domain;

public class Operand {
    private final Integer value;

    public Operand(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return this.value;
    }

    public static Operand of(String value) {
        return new Operand(Integer.parseInt(value));
    }
}
