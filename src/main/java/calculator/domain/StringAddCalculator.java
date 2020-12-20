package calculator.domain;

import java.util.List;

public class StringAddCalculator {

    private final InputNumber inputNumber;

    public StringAddCalculator(InputNumber inputNumber) {
        this.inputNumber = inputNumber;
    }

    public static int splitAndSum(String input) {
        InputNumber inputNumber = new InputNumber(input);
        return calculate(inputNumber);
    }

    public int calculate() {
        return calculate(inputNumber);
    }

    public static int calculate(InputNumber inputNumber) {
        if (inputNumber.isEmpty()) {
            return 0;
        }
        if (inputNumber.isOneLength()) {
            return inputNumber.getNumber();
        }
        return addition(inputNumber.getNumbers());
    }

    private static int addition(List<Integer> split) {
        return split.stream()
            .reduce(Integer::sum)
            .orElseThrow(IllegalArgumentException::new);
    }
}
