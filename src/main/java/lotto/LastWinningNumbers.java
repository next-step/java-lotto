package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LastWinningNumbers {

    private final List<Integer> winningNumbers;

    private LastWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static LastWinningNumbers newWinningNumbers(List<Integer> winningNumbers) {
        validate(winningNumbers);
        return new LastWinningNumbers(winningNumbers);
    }

    private static void validate(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("지난 주 당첨 번호는 6개이어야 합니다.");
        }

        Set<Integer> winningNumbersSet = new HashSet<>(winningNumbers);
        if (winningNumbersSet.size() != 6) {
            throw new IllegalArgumentException("지난 주 당첨 번호는 중복될 수 없습니다.");
        }

        for (Integer integer : winningNumbers) {
            validateMinAndMax(integer);
        }
    }

    private static void validateMinAndMax(Integer integer) {
        if (integer > LottoTotalNumberUtils.LOTTO_NUMBER_MAXIMUM) {
            throw new IllegalArgumentException("지난 주 번호는 45보다 클 수 없습니다.");
        }

        if (integer < LottoTotalNumberUtils.LOTTO_NUMBER_MINIMUM) {
            throw new IllegalArgumentException("지난 주 번호는 1보다 작을 수 없습니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }
}
