package stringcalculator.domain;

import java.util.List;

public class StringCalculator {

    private StringCalculator() {
    }

    public static int execute(List<Integer> numbers) {
        return numbers.stream().reduce(0, Operation.PLUS::operate);
    }

}
