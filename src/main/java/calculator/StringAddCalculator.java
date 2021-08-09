package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringAddCalculator {

    private static String delimiters = ",|:";
    private static String negative = "-";

    public int splitAndSum(String data) {
        if (isBlank(data)) return 0;

        validate(data);
        String filteredData = findNumber(data);
        String[] tokens = filteredData.split(delimiters);

        return sum(tokens);
    }

    private int sum(String[] tokens) {
        return Stream.of(tokens)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private boolean isBlank(String data) {
        if (Objects.isNull(data) || data.isEmpty()) {
            return true;
        }
        return false;
    }

    private void validate(String data) {
        if (data.contains(negative)) {
            throw new RuntimeException("음수 데이터가 있습니다.");
        }
    }

    private String findNumber(String data) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(data);
        if (m.find()) {
            String customDelimiter = m.group(1);
            combineDelimiter(customDelimiter);
            data = m.group(2);
        }
        return data;
    }

    private void combineDelimiter(String customDelimiter) {
        delimiters = String.join("|", delimiters, customDelimiter);
    }
}
