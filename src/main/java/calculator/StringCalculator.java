package calculator;

import static calculator.exception.ExceptionMessage.ERROR_EMPTY_VALUE;
import static calculator.exception.ExceptionMessage.ERROR_INVALID_VALUE_CALCULATE;

import calculator.domain.PositiveInt;
import calculator.domain.Operator;

public class StringCalculator {

    private static final StringCalculator INSTANCE = new StringCalculator();
    private static final int OPERATOR_INDEX = 2;
    private static final int MIN_TOKEN = 3;

    private StringCalculator() {
    }

    public int calculate(String[] tokens) {
        validateTokens(tokens);

        PositiveInt result = PositiveInt.from(tokens[0]);
        for (int i = 1; i < tokens.length - 1; i += OPERATOR_INDEX) {
            result = intermediateCalculate(result, tokens[i], tokens[i + 1]);
        }

        return result.getValue();
    }

    private void validateTokens(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE.getMessage());
        }

        if (tokens.length < MIN_TOKEN) {
            throw new IllegalArgumentException(ERROR_INVALID_VALUE_CALCULATE.getMessage());
        }
    }

    private PositiveInt intermediateCalculate(PositiveInt x, String sign, String number) {
        Operator operator = Operator.findBySign(sign);
        PositiveInt y = PositiveInt.from(number);

        return x.calculate(y, operator);
    }

    public static StringCalculator getInstance() {
        return INSTANCE;
    }
}
