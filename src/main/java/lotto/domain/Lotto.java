package lotto.domain;

import java.util.List;
import java.util.Objects;

import static lotto.domain.LottoRuleConfig.*;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;
    private final boolean isAutoGeneration;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.isAutoGeneration = true;
        lottoSizeException();
    }

    public Lotto(List<LottoNumber> lottoNumbers,boolean isAutoGeneration) {
        this.lottoNumbers = lottoNumbers;
        this.isAutoGeneration = isAutoGeneration;
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

    public boolean isAutoGeneration() {
        return isAutoGeneration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return isAutoGeneration == lotto.isAutoGeneration &&
                Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers, isAutoGeneration);
    }
}
