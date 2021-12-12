package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final String winningNumbers;

    public WinningNumbers(String winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public NumberGroup numberGroup() {
        String[] numbers = winningNumbers.split(",");
        int[] index = {0};
        return new NumberGroup(Arrays.stream(numbers).map(n -> new Number(Integer.parseInt(n.trim()), new Position(index[0]++))).collect(Collectors.toList()));
    }
}
