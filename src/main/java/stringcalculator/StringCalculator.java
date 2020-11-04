package stringcalculator;

import java.util.List;

public class StringCalculator {
    public int sum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        StringParser stringParser = new StringParser();
        List<Integer> numbers = stringParser.getNumbersFrom(input);

        int result = 0;
        for (Integer number : numbers) {
            if (number < 0) {
                throw new RuntimeException();
            }

            result += number;
        }

        return result;
    }

}
