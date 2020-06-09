import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntUnaryOperator;

public class StringAddCalculator {

    private static final String CUSTOM_DELIMITER_WRAPPER = "\n";
    private static final String DEFAULT_DELIMITER = ",|\\:";
    private static final int ZERO = 0;

    public static int splitAndSum(String text) {
        if(isNull(text)) {
            return ZERO;
        }
        if(text.isEmpty()) {
            return ZERO;
        }
        if(isNumeric(text)) {
            return parseInt(text);
        };
        if(hasCustomDelimiter(text)){
            return sumCustom(text);
        }
        return sum(text, DEFAULT_DELIMITER);
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
            if(isNegative(number)) {
                throw new RuntimeException();
            }
            return number;
        };
    }

    private static boolean isNegative(int number) {
        return number < 0;
    }

    public static String getDelimiter(String text) {
        int index = indexOfSplit(text);
        return text.substring(2, index);
    }

    public static String getCalculableText(String text) {
        int index = indexOfSplit(text);
        return text.substring(index + 1);
    }

    private static boolean hasCustomDelimiter(String text) {
        return text.contains(CUSTOM_DELIMITER_WRAPPER);
    }

    private static int indexOfSplit(String text) {
        return text.indexOf(CUSTOM_DELIMITER_WRAPPER);
    }

    private static int parseInt(String text) {
        return Integer.parseInt(text);
    }

    private static boolean isNumeric(String text) {
        return text.chars().allMatch(Character::isDigit);
    }

    private static boolean isNull(String text) {
        return text == null;
    }

    static Consumer<Integer> lambdaWrapper(Consumer<Integer> consumer) {
        return i -> {
            try {
                consumer.accept(i);
            } catch (ArithmeticException e) {
                System.err.println(
                        "Arithmetic Exception occured : " + e.getMessage());
            }
        };
    }


}
