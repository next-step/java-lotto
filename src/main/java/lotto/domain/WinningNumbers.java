package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final String winningNumbers;

    public WinningNumbers(String winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public String[] numbers() {
        String[] numbers = winningNumbers.split(",");

        if (numbers.length != NumberGroup.LIMIT) {
            throw new IllegalArgumentException();
        }
        return numbers;
    }

    public NumberGroup numberGroup() {
        return new NumberGroup(Arrays.stream(numbers()).map(n -> new Number(Integer.parseInt(n.trim()))).collect(Collectors.toList()));
    }
}
