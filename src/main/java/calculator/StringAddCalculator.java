package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {

    public static final String IS_NUMBER_REGEX = "[0-9]+";
    public static final String SEPARATOR_REGEX = "[,:]";

    public StringAddCalculator() {
    }

    public static int splitAndSum(String input) {
        // validate
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // int result = 0;

        List<Integer> numbers = split(input);
        // result = sum(numbers);
        // 숫자인지아닌지 사이즈비교

        return sum(numbers);
    }

    private static List<Integer> split(String input) {
        String[] splitInputs = input.split(SEPARATOR_REGEX);

        return parsingNumber(splitInputs);
    }

    private static List<Integer> parsingNumber(String[] splitInputs) {
        List<Integer> numbers = new ArrayList<>();

        for (String input : splitInputs) {
            addByIsNumber(input, numbers);
        }

        return numbers;
    }

    private static void addByIsNumber(String input, List<Integer> numbers) {
        if(input.matches(IS_NUMBER_REGEX)) {
            numbers.add(Integer.parseInt(input));
        }
    }

    private static int sum(List<Integer> numbers) {
        int result = 0;

        for(int number : numbers) {
            result += number;
        }

        return result;
    }

}
