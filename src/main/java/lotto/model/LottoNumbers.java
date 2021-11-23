package lotto.model;

import common.model.Number;

import java.util.Comparator;
import java.util.List;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;
    private LottoRank lottoRank;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.lottoRank = LottoRank.MISS;
        sort();
    }

    private void sort() {
        lottoNumbers.sort(Comparator.comparingInt(LottoNumber::getNumber));
    }

    public void matchRank(Number matchCount) {
        this.lottoRank = LottoRank.valueOf(matchCount.getNumber());
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public LottoRank getLottoRank() {
        return lottoRank;
    }
}
