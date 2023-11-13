package domain;

import utils.MathUtils;

import static java.lang.Integer.parseInt;

public class Calculator {

    private Calculator() {
    }

    public static int calculateArithmetic(String[] operandsAndOperators) {

        int sum = parseInt(operandsAndOperators[0]);
        for (int i = 1; i < operandsAndOperators.length - 1; i += 2) {
            sum = getSum(operandsAndOperators, sum, i);
        }
        return sum;
    }

    private static int getSum(String[] operandsAndOperators, int sum, int i) {
        if (operandsAndOperators[i].equals("+")) {
            return MathUtils.add(sum, parseInt(operandsAndOperators[i + 1]));
        }
        if (operandsAndOperators[i].equals("-")) {
            return MathUtils.subtract(sum, parseInt(operandsAndOperators[i + 1]));
        }
        if (operandsAndOperators[i].equals("*")) {
            return MathUtils.multiply(sum, parseInt(operandsAndOperators[i + 1]));
        }
        if (operandsAndOperators[i].equals("/")) {
            return MathUtils.divide(sum, parseInt(operandsAndOperators[i + 1]));
        }
        return sum;
    }
}
