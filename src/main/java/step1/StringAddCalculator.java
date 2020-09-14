package step1;

import step1.algorithm.Calculate;
import step1.algorithm.CalculateUsingDelimiter;
import step1.util.CalculatorUtil;

import java.util.Objects;

public class StringAddCalculator {

    public static int splitAndSum(String expression, Calculate calculate) {
        if (Objects.isNull(expression)) {
            return 0;
        }

        if (expression.trim().isEmpty()) {
            return 0;
        }

        String[] delimiterRegex = CalculatorUtil.getOperands(expression);

        return calculate.execute(delimiterRegex);
    }
}


