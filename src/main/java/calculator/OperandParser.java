package calculator;

import calculator.exception.InvalidOperandException;

public class OperandParser {

    public static int parse(String operandStr) {
        try {
            return Integer.parseInt(operandStr);
        } catch (Exception e) {
            throw new InvalidOperandException();
        }
    }
}
