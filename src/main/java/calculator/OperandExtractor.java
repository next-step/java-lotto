package calculator;

import calculator.util.CommonUtil;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperandExtractor {

    private final static String DEFAULT_SEPARATOR = ",|:";
    private final static String CUSTOM_SEPARATOR_PATTERN = "//(.)\n(.*)";

    public static PositiveNumber[] getOperand(String formula) {
        try {
            CommonUtil.validateNullEmpty(formula, "argument is null");
            String[] operands = getOperandByCustomSeparator(formula);
            if(operands == null) {
                operands = formula.split(DEFAULT_SEPARATOR);
            }
            return valuesOf(operands);
        }
        catch (IllegalArgumentException e) {
            return new PositiveNumber[] {PositiveNumber.of(formula)};
        }
    }

    private static PositiveNumber[] valuesOf(String[] operandStrings) {
        return Arrays.stream(operandStrings)
                .map(PositiveNumber::of).toArray(PositiveNumber[]::new);
    }

    private static String[] getOperandByCustomSeparator(String text) {
        String[] operands = null;
        Matcher m = Pattern.compile(CUSTOM_SEPARATOR_PATTERN).matcher(text);
        if(m.find()) {
            String separator = m.group(1);
            operands = m.group(2).split(separator);
        }
        return operands;
    }
}
