package calculator.domain;

public class TargetNumber {
    private final int firstNumber;
    private final int secondNumber;

    public TargetNumber(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int plus() {
        return this.firstNumber + this.secondNumber;
    }

    public int minus() {
        return this.firstNumber - this.secondNumber;
    }

    public int multiplication() {
        return this.firstNumber * this.secondNumber;
    }

    public int division() {
        return this.firstNumber / this.secondNumber;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }
}
