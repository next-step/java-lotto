package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public int splitAndSum(String value) {
        if (value == null || value.equals("")) {
            return 0;
        }
        isNegative(value);
        return addCalculator(value);
    }

    private int addCalculator(String inputValue) {
        String[] values = inputValue.split("[^0-9]");
        return Arrays.stream(values)
                .mapToInt(this::add)
                .sum();
    }

    private int add(String value) {
        int sum = 0;
        if (isNumeric(value)) {
            sum += Integer.parseInt(value);
        }
        return sum;
    }

    private boolean isNumeric(String value) {
        return value.matches("[0-9]");
    }

    public void isNegative(String value) {
        Pattern pattern = Pattern.compile("-(?:[0-9])");
        Matcher matcher = pattern.matcher(value);

        if (matcher.find()) {
            throw new RuntimeException("입력값이 음수입니다.");
        }
    }
}
