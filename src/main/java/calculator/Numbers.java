package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Numbers {

    public static List<Integer> toListOfInt(String numbers) {
        return Arrays.stream(splitString(numbers))
                .map(Numbers::parseInt)
                .collect(Collectors.toList());
    }

    private static String[] splitString(String numbers) {
        if (!isValidNumber(numbers)) return new String[]{"0"};

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(numbers);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return numbers.split(",|:");
    }

    private static int parseInt(String number) {
        if (!isValidNumber(number)) return 0;

        int parsedInt = Integer.parseInt(number);

        if (parsedInt < 0) {
            throw new RuntimeException("음수는 포함될 수 없습니다.");
        }
        return Integer.parseInt(number);
    }

    private static boolean isValidNumber(String number) {
        return number != null && !number.isEmpty();
    }
}
