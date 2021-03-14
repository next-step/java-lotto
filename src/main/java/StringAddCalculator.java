import util.Tokenizer;

import java.util.Arrays;

public class StringAddCalculator {
    public int splitAndSum(String parameter) {
        if (!isNotNullAndNotEmptyString(parameter)) {
            return 0;
        }
        Tokenizer tokenizer = new Tokenizer(parameter);

        String[] numbers = tokenizer.generateNumbers();
        if (containsMinusNumbers(numbers)) {
            throw new RuntimeException();
        }
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private boolean containsMinusNumbers(String[] numbers) {
        int[] minusNumbers = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .filter(i -> i < 0)
                .toArray();
        return minusNumbers.length > 0;
    }

    private boolean isNotNullAndNotEmptyString(String parameter) {
        if (parameter == null) {
            return false;
        }
        if (parameter.equals("")) {
            return false;
        }
        return true;
    }
}
