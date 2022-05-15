package calculator.domain;


import calculator.util.StringNumberUtils;

public class Operand {
    private final int number;

    Operand(int number) {
        this.number = number;
    }

    public static Operand create(String stringNumber) {
        return new Operand(StringNumberUtils.parse(stringNumber));
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operand operand = (Operand) o;

        return number == operand.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return "Operand{" +
                "number=" + number +
                '}';
    }
}
