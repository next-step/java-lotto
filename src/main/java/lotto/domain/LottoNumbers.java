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

    public LottoRank lottoRank(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        int matchingCount = getMatchingCount(lottoNumbers);
        boolean ismatchingBonus = lottoNumbers.bonusMatchingCount(bonusNumber);
        return LottoRank.rank(matchingCount, ismatchingBonus);
    }

    public boolean bonusMatchingCount(LottoNumber bonusNumber) {
        return this.lottoNumbers.stream()
                .anyMatch(lottoNumber -> checkMatching(bonusNumber));
      }

    public boolean checkMatching(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    private int getMatchingCount(LottoNumbers lottoNumbers) {
        return lottoNumbers.getMatchingCount(this.lottoNumbers);
    }

    private int getMatchingCount(List<LottoNumber> lottoNumbers) {
        List<LottoNumber> copyLottoNumbers = new ArrayList<>(this.lottoNumbers);
        copyLottoNumbers.retainAll(lottoNumbers);
        return copyLottoNumbers.size();
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


}
