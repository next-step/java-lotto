package calculator;

import calculator.number.PositiveInt;
import calculator.operator.Operator;

public class StringCalculator {

    private static final StringCalculator INSTANCE = new StringCalculator();

    private StringCalculator() {
    }

    public int calculate(String[] tokens) {
        validateTokens(tokens);

        PositiveInt result = PositiveInt.from(tokens[0]);
        for (int i = 1; i < tokens.length - 1; i += 2) {
            result = intermediateCalculate(result, tokens[i], tokens[i + 1]);
        }

        return result.getValue();
    }

    private void validateTokens(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            throw new IllegalArgumentException("문자열이 누락되었습니다.");
        }

        if (tokens.length < 3) {
            throw new IllegalArgumentException("계산할 수 없는 식입니다.");
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
