package calculator;

import calculator.to.StringSumCalculatorInput;
import utils.StringUtils;

import java.util.stream.Stream;

public class StringSumCalculator {

    private static final String DEFAULT_DELIMITER_REGEX = ",|:";

    public static int sum(String source) {
        StringSumCalculatorInput stringSumCalculatorInput = InputParser.parse(source);
        return Stream.of(StringUtils.splitWith(stringSumCalculatorInput.getParameters(), getDelimiter(stringSumCalculatorInput.getDelimiter())))
                .mapToInt(OperandCollector::collect)
                .sum();
    }

    private static String getDelimiter(String delimiter) {
        return delimiter != null ? delimiter : DEFAULT_DELIMITER_REGEX;
    }
}
