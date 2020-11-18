package humbledude.stringaddcalculator;

import java.util.List;

public class StringAddCalculator {


    public static int splitAndSum(String input) {
        if (!isEmptyInput(input)) {
            return 0;
        }

        List<Integer> numbers = InputParser.parse(input);
        return numbers.stream().mapToInt(Integer::intValue)
                .sum();
    }

    private static boolean isEmptyInput(String input) {
        if (input == null) {
            return false;
        }
        if (input.isEmpty()) {
            return false;
        }

        return true;
    }

}
