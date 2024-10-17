package lotto.domain.ticket;

import lotto.domain.winning.WinningNumbers;

import java.util.Objects;

public class LottoNumber {
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;

    private final Integer lottoNumber;

    public LottoNumber(Integer lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public boolean matchWinningNumbers(WinningNumbers winningNumbers) {
        return winningNumbers.getWinningNumbers()
                             .stream()
                             .anyMatch(lottoNumber::equals);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
