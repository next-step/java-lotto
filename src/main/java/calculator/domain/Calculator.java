package calculator.domain;

import java.util.List;

public class Calculator {

    private final InputNumber inputNumber;

    public Calculator(InputNumber inputNumber) {
        this.inputNumber = inputNumber;
    }

    public int calculate() {
        if (inputNumber.isEmpty()) {
            return 0;
        }
        if (inputNumber.isOneLength()) {
            return inputNumber.getNumber();
        }
        return addition(inputNumber.getNumbers());
    }

    private int addition(List<Integer> split) {
        return split.stream()
            .reduce(Integer::sum)
            .orElseThrow(IllegalArgumentException::new);
    }
}
