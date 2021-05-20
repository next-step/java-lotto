package calculator;

public class Number {

    private final int number;

    public Number(String number) {
        this(Integer.parseInt(number));
    }

    public Number(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        this.number = number;
    }

    public String toString() {
        return Integer.toString(number);
    }

    public int accumulate(int sum) {
        return number + sum;
    }
}