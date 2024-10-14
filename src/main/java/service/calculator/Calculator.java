package service.calculator;

import parser.InputParser;
import service.Arithmetic.*;

import java.util.List;

public class Calculator {

    public Calculator() {
    }

    public int calculate(String calculateString) {
        List<Integer> numbers = InputParser.parseNumbers(calculateString);
        List<Character> operations = InputParser.parseOperations(calculateString);

        return calculate(numbers, operations);
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
            Plus plus = new Plus();
            return plus.calculate(num1, num2);
        }

        if (operation == '-') {
            Subtract subtract = new Subtract();
            return subtract.calculate(num1, num2);
        }

        if (operation == '*') {
            Multiply multiply = new Multiply();
            return multiply.calculate(num1, num2);
        }

        if (operation == '/') {
            Devide devide = new Devide();
            return devide.calculate(num1, num2);
        }

        return -1;
    }

}
