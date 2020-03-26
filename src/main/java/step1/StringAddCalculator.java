package step1;

import static step1.Numbers.INIT_VALUE;

public class StringAddCalculator {
    public static int calculate(String input) {
        if(InputChecker.isNullOrEmpty(input)) {
            return INIT_VALUE;
        }

        Numbers numbers = new Numbers(InputParser.parseInput(input));
        return numbers.addAll();
    }
}
