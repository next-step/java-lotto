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

    public int lottoRank(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        int matchingCount = getMatchingCount(lottoNumbers);
        int matchingCountWithBonus =matchingCount + lottoNumbers.matchingCountWithBonus(bonusNumber);
        return LottoRank.convertMatchingCountToRank(matchingCount, matchingCountWithBonus);
    }

    public int matchingCountWithBonus(LottoNumber bonusNumber) {
        return this.lottoNumbers.stream()
                .filter(lottoNumber -> checkMatching(bonusNumber)) // 필터링 조건
                .findAny() // 일치하는 요소가 있는지 확인
                .map(lottoNumber -> 1) // 일치하는 경우 1로 매핑
                .orElse(0);
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
/*
    protected List<Integer> convertIntLottoNumbersList() {
        List<Integer> totalLottoNumbersList = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            totalLottoNumbersList.add(lottoNumber);
        }
        return totalLottoNumbersList;
    }
*/



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
