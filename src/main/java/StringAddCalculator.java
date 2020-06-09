import com.sun.org.apache.xerces.internal.impl.xs.opti.DefaultText;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class StringAddCalculator {

    private static final int CUSTOM_DELIMITER_WRAPPER_BEGIN_INDEX = 2;
    private static final String CUSTOM_DELIMITER_WRAPPER_END = "\n";
    private static final String DEFAULT_DELIMITER = ",|\\:";

    public static int splitAndSum(String text) {
        if(StringUtil.isNull(text) || StringUtil.isEmpty(text)) {
            return NumberUtil.ZERO;
        }
        if(StringUtil.isNumeric(text)) {
            return StringUtil.parseInt(text);
        };
        if(hasCustomDelimiter(text)){
            return sumCustom(text);
        }
        return sum(text, DEFAULT_DELIMITER);
    }

    public static String getDelimiter(String text) {
        int index = indexOfSplit(text);
        return text.substring(CUSTOM_DELIMITER_WRAPPER_BEGIN_INDEX, index);
    }

    public static String getCalculableText(String text) {
        int index = indexOfSplit(text);
        return text.substring(index + 1);
    }

    private static int sumCustom(String text) {
        String delimiter = getDelimiter(text);
        String calculableText = getCalculableText(text);
        return sum(calculableText, delimiter);
    }

    private static int sum(String text, String delimiter) {
        String[] numbers = text.split(delimiter);
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .map(getExceptionUnary())
                .sum();
    }

    private static IntUnaryOperator getExceptionUnary() {
        return number -> {
            if(NumberUtil.isNegative(number)) {
                throw new RuntimeException();
            }
            return number;
        };
    }

    private static boolean hasCustomDelimiter(String text) {
        return text.contains(CUSTOM_DELIMITER_WRAPPER_END);
    }

    private static int indexOfSplit(String text) {
        return text.indexOf(CUSTOM_DELIMITER_WRAPPER_END);
    }


}
