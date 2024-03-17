package lotto.util;

import lotto.exception.IllegalExpressionElementSizeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpressionSplitter {

    private static final String EXPRESSION_SEPARATOR_REGEX = " ";

    public static List<String> split(String stringExpression) throws IllegalExpressionElementSizeException {
        String[] elements = stringExpression.split(EXPRESSION_SEPARATOR_REGEX);
        return convertArrayToList(elements);
    }

    private static List<String> convertArrayToList(String[] stringArray) {
        return new ArrayList<>(Arrays.asList(stringArray));
    }
}
