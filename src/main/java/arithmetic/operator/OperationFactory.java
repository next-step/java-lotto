package arithmetic.operator;

import java.util.Arrays;

public class OperationFactory {
    public static final Operation ADDITION = new Addition();
    public static final Operation SUBTRACTION = new Subtraction();
    public static final Operation MULTIPLICATION = new Multiplication();
    public static final Operation DIVISION = new Division();
    private static final String ADDITION_SYMBOL = "+";
    private static final String SUBTRACTION_SYMBOL = "-";
    private static final String MULTIPLICATION_SYMBOL = "*";
    private static final String DIVISION_SYMBOL = "/";
    
    public static Operation getInstance(String operation) {
        if (invalidOperation(operation)) {
            throw new UnsupportedOperationException("Operator not supported.");
        }
        return getOperation(operation);
    }

    private static Operation getOperation(String operation) {
        if (operation.equals(ADDITION_SYMBOL)) {
            return ADDITION;
        } 
        if (operation.equals(SUBTRACTION_SYMBOL)) {
            return SUBTRACTION;
        } 
        if (operation.equals(MULTIPLICATION_SYMBOL)) {
            return MULTIPLICATION;
        } 
        return DIVISION;
    }

    private static boolean invalidOperation(String operation) {
        return operation == null || operation.isBlank() || !Arrays.asList(ADDITION_SYMBOL, SUBTRACTION_SYMBOL, MULTIPLICATION_SYMBOL, DIVISION_SYMBOL).contains(operation);
    }
}
