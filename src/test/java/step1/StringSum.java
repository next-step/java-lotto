package step1;

import java.util.Arrays;

public class StringSum {

    private final String reg;

    public StringSum(String reg) {
        this.reg = reg;
    }

    public Result sum(String input) {
        if (isEmpty(input)) {
            return new Result(0);
        }

        Integer sum = calculateInput(input);
        return new Result(sum);
    }

    private boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private Integer calculateInput(String input) {
        String[] numbers = input.split(reg);

        return Arrays.stream(numbers)
            .map(Integer::parseInt)
            .reduce(0, Integer::sum);
    }
}
