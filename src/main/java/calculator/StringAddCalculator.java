package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {

    public static final String IS_NUMBER_REGEX = "[0-9]+";

    public StringAddCalculator() {
    }

    public static int splitAndSum(String input) {
        // validate
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int result = 0;

        // 조건문
        String[] splitInputs = input.split(",");
        List<Integer> numbers = parsingNumber(splitInputs);

        // 숫자인지아닌지 사이즈비교

        for(int number : numbers) {
            result += number;
        }

        return result;
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

}
