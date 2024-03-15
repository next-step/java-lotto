package lotto.util;

import lotto.exception.IllegalEmptyExpressionException;
import lotto.exception.IllegalExpressionElementSizeException;

public class InputValidator {

    public static void validateEmptyExpression(String inputString) throws IllegalEmptyExpressionException {
        if (isEmptyExpression(inputString)) {
            throw new IllegalEmptyExpressionException(inputString);
        }
    }

    private static boolean isEmptyExpression(String inputString) {
        return inputString == null || inputString.isEmpty();
    }

    public static void validateElementSize(int size) throws IllegalExpressionElementSizeException {
        if (isEven(size)) {
            throw new IllegalExpressionElementSizeException(size);
        }
    }

    private static boolean isEven(int size) {
        return size % 2 == 0;
    }
}
