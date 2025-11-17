package calculator.domain;

public class TargetNumber {
    private final int firstNumber;
    private final int secondNumber;

    public TargetNumber(String firstNumber, String secondNumber) {
        this.firstNumber = Integer.parseInt(firstNumber);
        this.secondNumber = Integer.parseInt(secondNumber);
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
}
