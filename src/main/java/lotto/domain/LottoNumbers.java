package lotto.domain;

import lotto.LottoRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbers(List<LottoNumber> lottoWinningList) {
        lottoNumbers.addAll(lottoWinningList);
        checkSize();
    }

    private void checkSize() {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }


    public boolean bonusMatchingCount(LottoNumber bonusNumber) {
        return this.lottoNumbers.stream()
                .anyMatch(lottoNumber -> checkMatching(bonusNumber));
      }

    public boolean checkMatching(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }


    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
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
        return Objects.hashCode(lottoNumbers);
    }


    public int getMatchingCount(LottoNumbers lottoNumbers) {
        List<LottoNumber> copyLottoNumbers = new ArrayList<>(lottoNumbers.getLottoNumbers());
        copyLottoNumbers.retainAll(this.lottoNumbers);
        return copyLottoNumbers.size();
    }
}
