package calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private static final String SEPARATOR_PREFIX = "//";
    private static final String SEPARATOR_POSTFIX = "\n";

    private StringCalculator() {}

    public static Number sum(String data) {
        String separator = extractSeparator(data);
        String numberData = extractNumberData(data);
        NumberSplitter numberSplitter = new NumberSplitter(separator);

        List<Number> numbers = numberSplitter.split(numberData);
        return numbers.stream()
                .reduce(Number::sum)
                .orElseThrow(() -> new ArithmeticException("계산 중 잘못되어 null 이 반환되었습니다"));
    }

    private static String extractSeparator(String data) {
        List<String> strings = Arrays.asList(
                data.split(SEPARATOR_POSTFIX));
        if (strings.size() <= 1) {
            return "";
        }
        return strings.get(0)
                .split(SEPARATOR_PREFIX)[1];
    }

    private static String extractNumberData(String data) {
        List<String> strings = Arrays.asList(
                data.split(SEPARATOR_POSTFIX));
        if (strings.size() <= 1) {
            return data;
        }
        return strings.get(
                strings.size() - 1);
    }
}
