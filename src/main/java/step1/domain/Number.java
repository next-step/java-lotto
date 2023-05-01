package step1.domain;

public class Number {
    private final long number;

    public Number(long number) {
        this.number = number;
    }

    public static Number of(String number) {
        checkNumber(number);
        return new Number(Long.parseLong(number));
    }

    public static void checkNumber(String number) {
        if(!number.matches("^-?\\d+(\\.\\d+)?$")) {
            throw new IllegalArgumentException("Wrong number!");
        }
    }

    public Number operate(Operator operator, Number target) {
        return new Number(operator.calculate(this.number, target.number));
    }

    public long getNumber() {
        return this.number;
    }
}
