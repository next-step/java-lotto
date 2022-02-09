package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private static final String SPACES = "\\s+";
    private static final String EMPTY_STRING = "";
    private static final String DELIMITER_COMMA = ",";
    private static final int NUMBER_OF_LOTTO_BALL = 6;

    private final List<String> values;

    public WinningNumbers(String inputWinningNumbers) {
        inputWinningNumbers = removeBlank(inputWinningNumbers);
        validateInputFormat(inputWinningNumbers);
        final List<String> winningNumbers = splitNumber(inputWinningNumbers);

        validateWinningNumberCount(winningNumbers);
        validateWinningNumberRange(winningNumbers);

        this.values = winningNumbers;
    }

    private String removeBlank(final String inputNumbers) {
        return inputNumbers.replaceAll(SPACES, EMPTY_STRING);
    }

    private void validateInputFormat(final String numbers) {
        if (!numbers.matches(getValidateRegex())) {
            throw new IllegalArgumentException("구분자와 숫자만으로 이루어져야 합니다.");
        }
    }

    private String getValidateRegex() {
        return String.format("[0-9%s]+$", DELIMITER_COMMA);
    }

    private List<String> splitNumber(final String winningNumbers) {
        String[] split = winningNumbers.split(DELIMITER_COMMA);

        return Arrays.stream(split)
            .collect(Collectors.toList());
    }

    private void validateWinningNumberCount(final List<String> winningNumbers) {
        if (winningNumbers.size() != NUMBER_OF_LOTTO_BALL) {
            throw new IllegalArgumentException("당첨 번호는 6개 입니다.");
        }
    }

    private void validateWinningNumberRange(final List<String> winningNumbers) {
        if (!LottoBalls.get().containsAll(winningNumbers)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 까지 입니다.");
        }
    }

    public List<String> get() {
        return this.values;
    }
}
