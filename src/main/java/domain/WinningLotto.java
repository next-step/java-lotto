package domain;

import java.util.Set;
import java.util.stream.Collectors;

public class WinningLotto {
    private static final int WINNING_LOTTO_NUMBER = 6;

    private final Set<Number> winningNumbers;
    private final Number bonusNumber;

    public WinningLotto(Set<Number> winningNumbers, Number bonusNumber) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers;
        checkExist(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void checkExist(Number bonusNumber) {
        boolean isExist = winningNumbers.contains(bonusNumber);
        if (isExist) {
            throw new IllegalArgumentException("보너스 번호는 로또 숫자와 중복되면 안 됩니다");
        }
    }

    private void validate(Set<Number> numbers) {
        if (numbers.size() != WINNING_LOTTO_NUMBER) {
            throw new IllegalArgumentException("당첨 번호는 6개의 다른 값 이여야 합니다.");
        }
    }

    public boolean isMatchBonusNumber(Number number) {
        return number.equals(bonusNumber);
    }

    public boolean isContainInWinningNumber(Number number) {
        return winningNumbers.contains(number);
    }
}
