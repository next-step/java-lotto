package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultView {
    private static final int WINNING_NUMBER_SIZE = 6;
    private static final String SPLIT_TEXT = ",";

    private LottoNumber winningNumbers;

    public ResultView(String inputText) {
        Set<Integer> numbers = splitWinningNumber(inputText);
        validateWinningNumbers(numbers);
        winningNumbers = new LottoNumber(numbers);

    }

    private Set<Integer> splitWinningNumber(String inputText) {
        return Arrays
                .stream(inputText.split(SPLIT_TEXT))
                .map(num -> Integer.parseInt(num))
                .collect(Collectors.toSet());
    }

    private void validateWinningNumbers(Set<Integer> numbers) {
        if (numbers.size() < WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException("다른 숫자를 여섯개 입력해주세요.");
        }

    }
}
