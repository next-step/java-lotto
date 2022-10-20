package domain;

public class Number {
    int number;

    public Number(String value) {
        if (!isIntegerNumber(value)) {
            throw new NumberFormatException("정수가 아닙니다.");
        }
        this.number = Integer.valueOf(value);
    }

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private boolean isIntegerNumber(String value) {
        return (Double.valueOf(value)) % 1 == 0;
    }
}
