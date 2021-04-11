package lotto.domain;

import java.util.List;
import java.util.Objects;

public class BonusBall {
    private final LottoNumber bonusNumber;

    public BonusBall(int bonusNumber) {
        this(LottoNumber.of(bonusNumber));
    }

    public BonusBall(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public boolean isPartOf(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    public boolean isPartOf(LottoNumbers lottoNumbers) {
        return isPartOf(lottoNumbers.lottoNumbers());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusBall bonusBall = (BonusBall) o;
        return Objects.equals(bonusNumber, bonusBall.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusNumber);
    }
}
