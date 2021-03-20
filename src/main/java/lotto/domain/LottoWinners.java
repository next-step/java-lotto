package lotto.domain;

import java.util.Objects;

public class LottoWinners {

    private final LottoNumbers winnerNumbers;
    private final LottoNumber bonusNumber;

    public LottoWinners(String LottoWinners, int bonusNumber) {
        this.winnerNumbers = new LottoNumbers(LottoWinners);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public LottoWinners(LottoNumbers winnerNumbers, LottoNumber bonusNumber) {
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoNumbers winnerNumbers() {
        return winnerNumbers;
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
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
