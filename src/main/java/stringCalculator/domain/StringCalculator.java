package stringCalculator.domain;

public class StringCalculator {

    private Number firstNumber;
    private Number secondNumber;

    public StringCalculator(String firstNumber, String secondNumber) {
        this.firstNumber = new Number(firstNumber);
        this.secondNumber = new Number(secondNumber);
    }

    public int plus() {
        return firstNumber.getNumber() + secondNumber.getNumber();
    }

    public int minus() {
        return firstNumber.getNumber() - secondNumber.getNumber();
    }

    public int multiply() {
        return firstNumber.getNumber() * secondNumber.getNumber();
    }

    public int divide() {
        return firstNumber.getNumber() / secondNumber.getNumber();
    }
}
