package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbersParser {
    public static WinningNumbers parse(String input) {
        String[] tokens = input.split(",");
        List<Integer> numbers = Arrays.stream(tokens)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        validate(numbers);

        return new WinningNumbers(numbers);
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
    }
}
