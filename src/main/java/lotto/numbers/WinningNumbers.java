package lotto.numbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    public static List<Integer> getNumbers(String inputNumbers) {
        return mapToWinningNumbers(inputNumbers);
    }

    private static List<Integer> mapToWinningNumbers(String inputNumbers) {
        String inputNumbersTrim = inputNumbers.replaceAll(" ", "");
        String[] numbersString = inputNumbersTrim.split(",");
        return Arrays.stream(numbersString).map(Integer::parseInt).collect(Collectors.toList());
    }
}
