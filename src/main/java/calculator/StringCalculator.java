package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    public static String[] splitString(String numbers) {
        if (!isValidNumber(numbers)) return new String[]{"0"};

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(numbers);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return numbers.split(",|:");
    }

    public static int parseInt(String number) {
        if (!isValidNumber(number)) return 0;

        int parsedInt = Integer.parseInt(number);

        if (parsedInt < 0) {
            throw new RuntimeException("음수는 포함될 수 없습니다.");
        }
        return Integer.parseInt(number);
    }

    public static int sum(String numbers) {
        String[] splitted = splitString(numbers);
        List<Integer> parsed = Arrays.stream(splitted).map(StringCalculator::parseInt).collect(Collectors.toList());
        int result = 0;

        for (int i : parsed) {
            result += i;
        }
        return result;
    }

    private static boolean isValidNumber(String number) {
        return number != null && !number.isEmpty();
    }
}
