package lotto.domain;

import java.util.List;

public class Lotto {
    LottoPrice price;
    List<LottoNumbers> lottoNumbers;

    public Lotto(LottoPrice price, List<LottoNumbers> lottoNumbers) {
        this.price = price;
        this.lottoNumbers = lottoNumbers;
    }

    public LottoResult getMatchResult(LottoNumbers winningNumbers) {
        LottoResult result = new LottoResult();


        for (LottoNumbers lottoNumbers : lottoNumbers) {
            LottoRank rank = lottoNumbers.getMatchedRank(winningNumbers);
            result.add(rank);
        }

        return result;
    }


    private boolean isMatched(int targetMatchCount, int matchedCount) {
        return targetMatchCount == matchedCount;
    }
}
