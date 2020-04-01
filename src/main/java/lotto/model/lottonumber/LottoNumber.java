package lotto.model.lottonumber;

import java.util.List;
import java.util.Objects;

public class LottoNumber {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateNumberRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateNumberRange(int lottoNumber) {
        if(lottoNumber > LOTTO_NUMBER_MAX || lottoNumber < LOTTO_NUMBER_MIN){
            throw new IllegalArgumentException("로또는 1부터 45까지의 숫자로만 구성되어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
