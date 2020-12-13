package step2.domain;

public class Number {

    private int number;

    public Number(int number) {
        this.number = number;
        if (!isLotto()) throw new IllegalArgumentException();
    }

    public boolean isLotto() {
        return number > 0 && number <= 45;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Number number1 = (Number) o;

        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
