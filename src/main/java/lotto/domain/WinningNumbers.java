package lotto.domain;

import java.util.Set;

public class WinningNumbers {
    private final Lotto winningNumbers;
    private final Integer bonusNumber;

    private WinningNumbers(Set<Integer> winningNumbers, Integer bonusNumber) {
        validateBonusNumber(bonusNumber);
        validateDuplicateNumber(winningNumbers, bonusNumber);
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateNumber(Set<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스볼은 당첨번호와 중복될 수 없습니다.");
        }
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if (bonusNumber < Lotto.MIN_VALUE || bonusNumber > Lotto.MAX_VALUE) {
            throw new IllegalArgumentException("보너스볼은 1 ~ 45 사이의 숫자로 구성 되어야 합니다.");
        }
    }

    public static WinningNumbers of(Set<Integer> winningNumbers, Integer bonusNumber) {
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    public Set<Integer> getWinningNumbers() {
        return winningNumbers.getNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public boolean hasNumber(int number) {
        return winningNumbers.getNumbers().contains(number);
    }
}
