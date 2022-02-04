package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class CorrectNumbers {

    private static final int NUMBER_OF_BONUS_BALL = 1;
    private static final int NUMBER_OF_LOTTO_BALL = 6;

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public CorrectNumbers(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        validateDuplicateNumber(winningNumbers, bonusNumber);

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateNumber(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        Set<String> numbers = new HashSet<String>() {
            {
                addAll(winningNumbers.get());
                add(bonusNumber.get());
            }
        };

        if (numbers.size() < NUMBER_OF_LOTTO_BALL + NUMBER_OF_BONUS_BALL) {
            throw new IllegalArgumentException("중복된 숫자가 있을 수 없습니다.");
        }
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
