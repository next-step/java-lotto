package lotto.domain;

import java.util.List;
import java.util.Objects;

public class BonusNumber {
    private final LottoNumber number;

    public BonusNumber(int number) {
        this.number = new LottoNumber(number);
    }

    public boolean isContainedIn(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.contains(this.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusNumber that = (BonusNumber) o;
        return this.number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.number);
    }
}
