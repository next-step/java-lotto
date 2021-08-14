package lotto.domain;

import java.util.List;
import java.util.Objects;

public class WinningNumbers{

    private static final int LOTTO_NUMBER_SIZE = 6;
    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;
    public WinningNumbers(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(winningNumbers, that.winningNumbers) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonusNumber);
    }

    private void validateWinningNumbers(List<LottoNumber> winningNumbers) {
        if (winningNumbers == null || isLottoNumberSize(winningNumbers)) {
            throw new IllegalArgumentException("잘못된 지난 주 당첨 번호입니다.");
        }
    }

    private boolean isLottoNumberSize(List<LottoNumber> winningNumbers) {
        return winningNumbers.size() != LOTTO_NUMBER_SIZE;
    }

    public boolean contains(LottoNumber element) {
        return winningNumbers.contains(element);
    }
}
