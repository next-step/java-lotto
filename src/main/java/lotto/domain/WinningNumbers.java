package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WinningNumbers {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> winningNumbers;

    private WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;

        validateWinningNumberRange();
        validateWinningNumbersSize();
    }

    public static WinningNumbers from(List<Integer> winningNumbers) {
        return new WinningNumbers(winningNumbers);
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

    private void validateWinningNumberRange() {
        if (isWinningNumberInRange()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1 이상 45 이하로 입력해주세요.");
        }
    }

    private void validateWinningNumbersSize() {
        if (winningNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 개수는 6개로 입력해주세요.");
        }
    }

    private boolean isWinningNumberInRange() {
        List<Integer> validLottoNumber = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            .boxed().collect(
                Collectors.toList());

        return winningNumbers.stream()
            .anyMatch(winningNumber -> !validLottoNumber.contains(winningNumber));
    }
}
