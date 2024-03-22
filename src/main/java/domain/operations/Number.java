package domain.operations;

public class Number {
    private int number;

    public Number(String number) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("정수를 입력하세요");
        }
        this.number = Integer.parseInt(number);
    }

    public Number(int number) {
        this.number = number;
    }

    public int number() {
        return this.number;
    }

    public int minus(Number otherNumber) {
        return this.number - otherNumber.number();
    }

    public int divide(Number otherNumber) {
        return this.number / otherNumber.number();
    }

    public int multiply(Number otherNumber) {
        return this.number * otherNumber.number();
    }

    public int add(Number otherNumber) {
        return this.number + otherNumber.number();
    }
}
