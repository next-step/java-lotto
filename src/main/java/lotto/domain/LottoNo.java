package lotto.domain;

import java.util.Set;

public class LottoNo {

    private final int value;

    public LottoNo(int value) {
        this.value = value;
    }

    public boolean isValid() {
        return value >= LottoNumbers.LOTTO_START_NUMBER && value <= LottoNumbers.LOTTO_END_NUMBER;
    }

    public boolean isContains(Set<LottoNo> numbers) {
        return numbers.contains(new LottoNo(value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return value == lottoNo.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

}
