package step1;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {


    public static int splitAndSum(String inputData) {
        if (isEmpty(inputData)) {
            return 0;
        }

        List<Integer> numbers = convertIntegers(inputData.split(",|:"));

        if (isNumberOfOne(numbers)) {
            return numbers.get(0);
        }

        return sum(numbers);
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
