package calculator.model;

import calculator.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class OperatorParsing {

    private static final String ERROR_OPERATOR_MESSAGE = "입력한 수식이 올바르지 않습니다.";

    public static List<String> addOperator(String[] formulas) {
        List<String> operators = new ArrayList<>();

        for (int i = 1; i < formulas.length; i += 2) {
            operators.add(parse(formulas[i]));
        }

        return operators;
    }

    private static boolean isOperator(String input) {
        return input.matches("^[\\+\\-\\*\\/]$");
    }

    private static String parse(String input) {
        if (!isOperator(StringUtil.isEmpty(input))) {
            throw new IllegalArgumentException(ERROR_OPERATOR_MESSAGE);
        }
        return input;
    }
}
