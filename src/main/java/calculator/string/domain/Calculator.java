package calculator.string.domain;

public class Calculator {
    public int add(int previousNumber, int nextNumber) {
        return previousNumber + nextNumber;
    }

    public int substract(int previousNumber, int nextNumber) {
        return previousNumber - nextNumber;
    }

    public int multiply(int previousNumber, int nextNumber) {
        return previousNumber * nextNumber;
    }

    public int divide(int previousNumber, int nextNumber) {
        if(previousNumber % nextNumber != 0) {
            throw new IllegalArgumentException("나눗셈이 정수로 떨이지지 않습니다.");
        }
        return previousNumber / nextNumber;
    }
}
