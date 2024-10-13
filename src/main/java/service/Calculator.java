package service;

import java.util.List;

public class Calculator {

    public Calculator() {
    }

    public int calculate(List<Integer> numbers, List<Character> operations) {

        int result = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            int num2 = numbers.get(i);
            char operation = operations.get(i - 1);

            result = calculate(result, num2, operation);
        }

        return result;
    }

    public int calculate(int num1, int num2, Character operation) {
        if (operation == '+') {
            return add(num1, num2);
        }

        if (operation == '-') {
            return substract(num1, num2);
        }

        if (operation == '*') {
            return multiply(num1, num2);
        }

        if (operation == '/') {
            if (isInteger(num1, num2)) {
                return devide(num1, num2);
            }
        }

        return -1;
    }

    private int add(int num1, int num2) {
        return num1 + num2;
    }

    private int substract(int num1, int num2) {
        return num1 - num2;
    }

    private int multiply(int num1, int num2) {
        return num1 * num2;
    }

    private int devide(int num1, int num2) {
        return num1 / num2;
    }

    private boolean isInteger(int num1, int num2) {
        if (!(num1 % num2 == 0)) {
            throw new ArithmeticException("두 수의 나눗셈 결과가 정수가 아닙니다.");
        }
        return true;
    }
}
