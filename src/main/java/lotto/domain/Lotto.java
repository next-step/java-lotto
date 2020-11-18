package lotto.domain;

import java.util.List;
import java.util.Objects;

import static lotto.domain.LottoRuleConfig.*;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        lottoSizeException();
    }

    private void lottoSizeException() {
        overSizeNumber();
        underSizeNumber();
    }

    private void overSizeNumber() {
        if(lottoNumbers.size() > MAX_LOTTO_BALL_COUNT) {
            throw new IllegalArgumentException(OVER_SIZE_NUMBERS);
        }
    }

    private void underSizeNumber() {
        if(lottoNumbers.size() < MAX_LOTTO_BALL_COUNT) {
            throw new IllegalArgumentException(UNDER_SIZE_NUMBERS);
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
