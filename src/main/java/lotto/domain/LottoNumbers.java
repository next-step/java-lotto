package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    public static final int LOTTO_NUMBER_MAX_SIZE = 6;

    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(final List<LottoNumber> lottoNumbers) {
        checkLottoNumberSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void checkLottoNumberSize(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers != null && lottoNumbers.size() != LOTTO_NUMBER_MAX_SIZE) {
            throw new RuntimeException("로또 번호는 6개 숫자만 가집니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
