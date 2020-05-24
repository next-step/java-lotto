package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperandExtractor {

    private final static String DEFAULT_SEPARATOR = ",|:";
    private final static String CUSTOM_SEPARATOR_PATTERN = "//(.)\n(.*)";

    public static String[] getOperand(String formula) {
        try {
            validateNullEmpty(formula, "argument is null");
            String[] operands = getOperandByCustomSeparator(formula);
            if(operands == null) {
                operands = formula.split(DEFAULT_SEPARATOR);
            }
            return operands;
        }
        catch (IllegalArgumentException e) {
            return new String[] {"0"};
        }
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

    public static int[] valueOf(String[] operands) {
        int[] values = new int[operands.length];
        for (int i = 0 ; i < operands.length ; i++) {
            values[i] = getPositiveOperand(operands[i]);
        }
        return values;
    }

    private static int getPositiveOperand(String number) throws RuntimeException {
        int returnValue = Integer.parseInt(number);
        if(returnValue < 0) {
            throw new RuntimeException(number + "is negative!!");
        }
        return returnValue;
    }

    public static void validateNullEmpty(String text, String errMessage) throws IllegalArgumentException{
        if(text == null || text.isEmpty()) {
            throw new IllegalArgumentException(errMessage);
        }
    }
}
