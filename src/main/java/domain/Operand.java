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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Operand operand = (Operand) obj;
        return this.value.equals(operand.value());
    }
}
