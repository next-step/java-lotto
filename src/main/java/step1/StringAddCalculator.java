package step1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String NUMBER = "^[0-9]*$";

    public StringAddCalculator() {
    }

    public int splitAndSum(final String input) {
        if (isBlank(input)) {
            return 0;
        }

        return sum(parseToInt(split(input)));
    }

    public boolean isBlank(String input) {
        return Objects.isNull(input) || input.trim().isEmpty();
    }

    public String[] split(String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            return matcher.group(2).split(customSeparator);
        }
        return input.split(DEFAULT_SEPARATOR);
    }

    public List<Integer> parseToInt(String[] splitResult) {
        List<Integer> integers = new ArrayList<>();
        for (String inputValue : splitResult) {
            valid(inputValue);
            integers.add(Integer.parseInt(inputValue));
        }
        return integers;
    }

    public void valid(String inputNumber) {
        if (!inputNumber.matches(NUMBER)) {
            throw new RuntimeException("잘못된 데이터가 입력되었습니다.");
        }
    }

    public int sum(List<Integer> integers) {
        int result = 0;
        for (Integer value : integers) {
            result += value;
        }
        return result;
    }
}
