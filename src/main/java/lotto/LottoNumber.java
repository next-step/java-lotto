package lotto;

import java.util.List;
import java.util.Objects;

public class LottoNumber {
    private final List<Integer> lottoNumbers;

    public LottoNumber(List<Integer> lottoNumbers) {
        LottoValidationUtils.validationLottoNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public boolean isContainWinNumber(Integer winNumber) {
        return lottoNumbers.contains(winNumber);
    }

    public boolean isContainsBonusNumber(LottoBonusNumber bonusNumber) {
        return bonusNumber.isContainsBonusNumber(lottoNumbers);
    }

    public boolean lottoSize(int expectedSize) {
        return lottoNumbers.size() == expectedSize;
    }

    public int compareWinLotto(Lotto winLotto) {
        int countMatchNumber = 0;
        for (Integer winNumber : lottoNumbers) {
            countMatchNumber += winLotto.matchNumber(winNumber);
        }
        return countMatchNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
