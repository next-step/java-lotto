package step1.domain;

public class Operand {

    private final Integer value;

    public Operand(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Operand) {
            return this.value.equals(((Operand) o).value);
        }
        return false;
    }

    public Integer getValue() {
        return this.value;
    }
}
