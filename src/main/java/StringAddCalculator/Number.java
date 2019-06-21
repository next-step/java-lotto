package StringAddCalculator;

public class Number {


    private final int number;

    public Number(int number) {
        this.number = number;
    }

    public Number add(Number targetNumber) {
        return new Number(number + targetNumber.getNumber());
    }

    public int getNumber() {
        return this.number;
    }
}
