package step1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String inputData) {
        if (isEmpty(inputData)) {
            return 0;
        }

        List<Integer> numbers = convertIntegers(split(inputData));

        if (isNumberOfOne(numbers)) {
            return numbers.get(0);
        }
        return sum(numbers);
    }

    private static String[] split(String inputData) {
        String[] tokens = inputData.split(",|:");
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputData);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens= m.group(2).split(customDelimiter);
        }
        return tokens;
    }

    private static int sum(List<Integer> numbers) {
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }

    private static boolean isNumberOfOne(List<Integer> numbers) {
        return numbers.size() == 1;
    }

    private static List<Integer> convertIntegers(String[] splits) {
        List<Integer> numbers = new ArrayList<>();
        for (String split : splits) {
            int number = convertPositive(split);
            numbers.add(number);
        }
        return numbers;
    }

    private static int convertPositive(String split) {
        int number = Integer.parseInt(split);
        if (number < 0) throw new RuntimeException();
        return number;
    }

    private static boolean isEmpty(String inputData) {
        return inputData == null || inputData.trim().isEmpty();
    }
}
