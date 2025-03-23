package calculator;

import java.math.BigDecimal;
import java.util.List;

public class InOrderCalculator implements CalculateStrategy {
    @Override
    public BigDecimal calculate(List<String> tokens) {
        validate(tokens);
        BigDecimal result  = new BigDecimal(tokens.get(0));
        for (int i = 1; i < tokens.size(); i += 2) {
            result = calculate(result, tokens.get(i), new BigDecimal(tokens.get(i + 1)));
        }
        return result;
    }

    private void validate(List<String> tokens) {
        if (tokens == null || tokens.size() < 3 || tokens.size() % 2 == 0) {
            throw new IllegalArgumentException("수식이 올바르지 않습니다.");
        }
    }

    private BigDecimal calculate(BigDecimal number, String op, BigDecimal number2) {
        Operator operator = Operator.find(op);
        return operator.apply(number, number2);
    }
}
