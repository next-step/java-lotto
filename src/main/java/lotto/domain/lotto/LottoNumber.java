package lotto.domain.lotto;

import java.util.List;
import java.util.Objects;

import static lotto.domain.Constant.LOTTO_NUM_MAX;
import static lotto.domain.Constant.LOTTO_NUM_MIN;

public class LottoNumber {
    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        validateRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(int lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

    public boolean matches(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .anyMatch(e -> e == lottoNumber);
    }

    private void validateRange(int lottoNumber) {
        if (isValidRange(lottoNumber)) {
            throw new LottoNumberRangeException();
        }
    }

    public int intValue() {
        return lottoNumber;
    }

    private boolean isValidRange(int lottoNumber) {
        return lottoNumber < LOTTO_NUM_MIN || LOTTO_NUM_MAX < lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

}
