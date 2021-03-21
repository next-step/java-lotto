package lotto.domain;

import java.util.Objects;

public class LottoWinners {
    private static final String WINNER_BONUS_DUPLICATE_ERROR = "당첨번호와 보너스번호가 중복됩니다.";
    private final LottoNumbers winnerNumbers;
    private final LottoNumber bonusNumber;

    public LottoWinners(LottoNumbers winnerNumbers, LottoNumber bonusNumber) {
        isDuplicateWinnersInBonus(winnerNumbers, bonusNumber);
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoNumbers winnerNumbers() {
        return winnerNumbers;
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }

    private void isDuplicateWinnersInBonus(LottoNumbers winnerNumbers, LottoNumber bonusNumber) {
        boolean result = winnerNumbers.readOnlyNumbers().contains(bonusNumber);

        if (result) {
            throw new IllegalArgumentException(WINNER_BONUS_DUPLICATE_ERROR);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoWinners that = (LottoWinners) o;
        return Objects.equals(winnerNumbers, that.winnerNumbers) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerNumbers, bonusNumber);
    }
}
