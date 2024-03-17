package lotto.util;

import lotto.exception.IllegalEmptyExpressionException;
import lotto.exception.IllegalExpressionElementSizeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpressionSplitter {

    private static final String EXPRESSION_SEPARATOR_REGEX = " ";

    public static List<String> split(String stringExpression) throws IllegalExpressionElementSizeException {
        validateEmptyExpression(stringExpression);

        String[] elements = stringExpression.split(EXPRESSION_SEPARATOR_REGEX);
        validateElementSize(elements.length);

        return convertArrayToList(elements);
    }


    private static List<String> convertArrayToList(String[] stringArray) {
        return new ArrayList<>(Arrays.asList(stringArray));
    }

    private static void validateEmptyExpression(String inputString) throws IllegalEmptyExpressionException {
        if (isEmptyExpression(inputString)) {
            throw new IllegalEmptyExpressionException(inputString);
        }
    }

    private static boolean isEmptyExpression(String inputString) {
        return inputString == null || inputString.isBlank();
    }

    private static void validateElementSize(int size) throws IllegalExpressionElementSizeException {
        if (isEven(size)) {
            throw new IllegalExpressionElementSizeException(size);
        }
    }

    private static boolean isEven(int size) {
        return size % 2 == 0;
    }
}
