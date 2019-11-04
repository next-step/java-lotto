package calc;

import java.util.List;

public class StringAddCalculator {

    public int add(String input) {
        return add(new InputChecker(input).getNumbers());
    }

    private int add(List<Integer> numbers) {
        return numbers.stream()
            .reduce(0, Integer::sum);
    }
}
