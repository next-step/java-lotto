package domain;

public class Number {
    private Integer number;

    public Number(Integer number) {
        if (number < 1 || number > 46) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean numberCompare(Integer number) {
        return this.number == number;
    }
}
