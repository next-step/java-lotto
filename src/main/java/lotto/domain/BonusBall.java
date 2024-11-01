package lotto.domain;

import java.util.List;
import java.util.Objects;

public class BonusBall {
    private final LottoNumber bonusNumber;

    public BonusBall(int bonusNumber) {
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public boolean checkMatching(List<LottoNumber> lottoNumberList) {
        return lottoNumberList.contains(bonusNumber);
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
        return Objects.hashCode(bonusNumber);
    }

    public int matchingCountWithBonus(List<LottoNumber> lottoNumbers, int matchingCount) {
        if (matchingCount == 6) {
            return matchingCount;
        }
        if (checkMatching(lottoNumbers)) {
            return matchingCount + 1;
        }
        return matchingCount;
    }
}
