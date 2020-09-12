package step1;

import step1.algorithm.CalculateAlgorithm;
import step1.algorithm.CalculateUsingDelimiter;
import step1.util.CalculatorUtil;

import java.util.Objects;

public class StringAddCalculator {

    private static final CalculateAlgorithm CALCULATE_ALGORITHM = new CalculateUsingDelimiter();

    public static int splitAndSum(String expression) {
        if (Objects.isNull(expression)) {
            return 0;
        }

        if (expression.trim().isEmpty()) {
            return 0;
        }

        String[] delimiterRegex = CalculatorUtil.getOperands(expression)
                .orElseThrow(() -> new RuntimeException("커스텀 구분자, 기본 구분자를 사용하지 않았습니다."));

        return CALCULATE_ALGORITHM.execute(delimiterRegex);
    }
}


