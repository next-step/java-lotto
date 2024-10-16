package service.calculator;

import parser.InputParser;
import service.arithmetic.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {

    private static final Map<Character, Arithmetic> arithmetics = new HashMap<>();

    static {
        arithmetics.put('+', Plus.getInstance());
        arithmetics.put('-', Subtract.getInstance());
        arithmetics.put('*', Multiply.getInstance());
        arithmetics.put('/', Divide.getInstance());
    }

    private Calculator() {
    }

    public static int calculate(String calculateString) {
        List<Integer> numbers = InputParser.parseNumbers(calculateString);
        List<Character> operations = InputParser.parseOperations(calculateString);

        return calculate(numbers, operations);
    }

    private static int calculate(List<Integer> numbers, List<Character> operations) {

        int result = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            int num2 = numbers.get(i);
            char operation = operations.get(i - 1);

            result = calculate(result, num2, operation);
        }

        return result;
    }

    private static int calculate(int num1, int num2, Character operation) {
        Arithmetic arithmetic = arithmetics.get(operation);
        return arithmetic.calculate(num1, num2);
    }

}
