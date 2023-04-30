package step1.domain;

public class Operator {

    public static int plus(int existNumber, int targetNumber) {
        return existNumber + targetNumber;
    }

    public static int minus(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    public static int multiple(int firstNumber, int secondNumber) {
            return firstNumber * secondNumber;
    }

    public static int divide(int firstNumber, int secondNumber) {
        if(firstNumber == 0 || secondNumber == 0) {
            throw new IllegalArgumentException("Wrong number");
        }
        return firstNumber / secondNumber;
    }
}
