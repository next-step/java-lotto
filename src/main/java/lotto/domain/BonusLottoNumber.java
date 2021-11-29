package lotto.domain;

import java.util.Objects;

import static lotto.utils.Constants.MSG_BONUS_NUMBER_SAME_WINNING_NUMBERS;

public class BonusLottoNumber {
    private final int bonusNumber;

    public BonusLottoNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public BonusLottoNumber(int bonusNumber, LottoNumbers lastWeekWinningNumbers) {
        validateDifferentNumberFromWinningNumbers(bonusNumber, lastWeekWinningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateDifferentNumberFromWinningNumbers(int bonusNumber,
            LottoNumbers lastWeekWinningNumbers) {
        if (lastWeekWinningNumbers.isIncludeBonusNumber(bonusNumber)) {
            throw new IndexOutOfBoundsException(MSG_BONUS_NUMBER_SAME_WINNING_NUMBERS);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusLottoNumber that = (BonusLottoNumber) o;
        return bonusNumber == that.bonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusNumber);
    }
}
