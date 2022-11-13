package lotto.numbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberCreator {
    public static List<Integer> getNumbers(String inputNumbers) {
        validateString(inputNumbers);
        List<Integer> winningNumbers = mapToWinningNumbers(inputNumbers);
        validateListNumbers(winningNumbers);
        return winningNumbers;
    }

    private static List<Integer> mapToWinningNumbers(String inputNumbers) {
        String inputNumbersTrim = inputNumbers.replaceAll(" ", "");
        String[] numbersString = inputNumbersTrim.split(",");

        try {
            return Arrays.stream(numbersString).map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 당첨번호 형식입니다.");
        }
    }

    private static void validateListNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("올바르지 않은 당첨번호 형식입니다.");
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨번호는 6자리여야 합니다.");
        }
        if (!AllNumbers.getNumbers().containsAll(numbers)) {
            throw new IllegalArgumentException("당첨번호의 범위는 1~45 범위의 숫자여야 합니다.");
        }
    }

    private static void validateString(String inputNumbers) {
        if (inputNumbers == null || inputNumbers.isBlank()) {
            throw new IllegalArgumentException("당첨 번호를 입력해주세요.");
        }
    }
}
