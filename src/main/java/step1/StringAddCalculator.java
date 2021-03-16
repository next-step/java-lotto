package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input) {

        if(input == null || input.isEmpty())
            return 0;

        String delimiter = ",|:";
        String beforeSplit = input;
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (matcher.find()) {
            delimiter = matcher.group(1);
            beforeSplit = matcher.group(2);
        }

        return add(Arrays.stream(splitDelimiter(beforeSplit, delimiter))
                .mapToInt(Integer::parseInt)
                .toArray());
    }

    private static String[] splitDelimiter(String beforeSplit, String delimiter) {
        return beforeSplit.split(delimiter);
    }

    private static int add(int[] numbers) {

        int sum = 0;
        for (int number : numbers) {
            minusNumberCheck(number);
            sum += number;
        }

        return sum;
    }

    private static void minusNumberCheck(int number) {
        if(number < 0) {
            throw new RuntimeException("음수는 입력이 불가능 합니다.");
        }
    }
}
