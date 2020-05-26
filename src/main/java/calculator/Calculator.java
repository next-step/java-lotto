package calculator;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private final StringParser stringParser;

    public Calculator() {
        stringParser = new StringParser();
    }

    public int sum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        return getSum(stringParser.getNumbers(input));
    }

    private int getSum(List<Integer> numbers){
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.replaceAll(" ", "").isEmpty();
    }
}
