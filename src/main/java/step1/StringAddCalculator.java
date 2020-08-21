package step1;

import org.apache.commons.lang3.StringUtils;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        return StringUtils.isBlank(input) ? 0 : add(CalculationNumber.getCalculationNumbers(input));
    }

    private static int add(CalculationNumber calculationNumber) {
        return calculationNumber.getInnerNumbers()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
