package domain;

import utils.MathUtils;

import static java.lang.Integer.parseInt;

public class Calculator {

    private static int FIRST_OPERAND = 0;

    private Calculator() {
    }

    public static int calculateArithmetic(String[] operandsAndOperators) {

        int sum = parseInt(operandsAndOperators[FIRST_OPERAND]);
        for (int i = 1; i < operandsAndOperators.length - 1; i += 2) {
            Operation operation = Operation.fromSymbol(operandsAndOperators[i]);
            sum = operation.calculate(sum, parseInt(operandsAndOperators[i + 1]));
        }
        return sum;
    }
}
