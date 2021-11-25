package step1;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {


    public static int splitAndSum(String inputData) {
        if (isEmpty(inputData)) {
            return 0;
        }

        String[] splits = inputData.split(",|:");
        List<Integer> numbers = new ArrayList<>();
        int result = 0;

        convertIntegers(splits, numbers);

        if (isSizeOne(numbers)) {
            return numbers.get(0);
        }

        for (Integer number : numbers) {
            result += number;
        }

        return result;
    }

    private static boolean isSizeOne(List<Integer> numbers) {
        return numbers.size() == 1;
    }

    private static void convertIntegers(String[] splits, List<Integer> numbers) {
        for (String split : splits) {
            int number = getPositive(split);
            numbers.add(number);
        }
    }

    private static int getPositive(String split) {
        int number = Integer.parseInt(split);
        if (number < 0) throw new RuntimeException();
        return number;
    }

    private static boolean isEmpty(String inputData) {
        return "".equals(inputData) || inputData == null;
    }
}
