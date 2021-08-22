package domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {

    public static final int LOTTO_NUM_COUNT = 6;

    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(PickNumberStrategy pickNumberStrategy) {
        lottoNumbers = pickNumberStrategy.makeLottoNumber();
        validate();
    }

    private void validate() {
        if (lottoNumbers.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("로또의 사이즈는 " + LOTTO_NUM_COUNT + "개만 가능합니다.");
        }
    }

    public List<LottoNumber> getValues() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
