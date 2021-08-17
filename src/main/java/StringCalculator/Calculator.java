package StringCalculator;

import java.util.List;

public class Calculator {
    public WholeNumber calculate(String input) {
        WholeNumbers numbers = new WholeNumbers(InputParser.parseStringListToIntegerList(input));
        return new Addition().addAll(numbers);
    }
}
