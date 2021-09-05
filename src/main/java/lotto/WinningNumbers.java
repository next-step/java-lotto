package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    public List<Integer> numbers;

    public WinningNumbers(String winningNumbers) {
        numbers = parseNumbers(winningNumbers);
    }

    private List<Integer> parseNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
