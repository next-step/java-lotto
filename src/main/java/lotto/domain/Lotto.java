package lotto.domain;

import java.util.List;

public class Lotto {
    LottoPrice price;
    List<LottoNumbers> lottoNumbers;

    public Lotto(LottoPrice price, List<LottoNumbers> lottoNumbers) {
        this.price = price;
        this.lottoNumbers = lottoNumbers;
    }

    public int matches(int targetMatchCount, LottoNumbers winningNumbers) {
        int matchCount = 0;

        for (LottoNumbers lottoNumbers : lottoNumbers) {
            if (isMatched(targetMatchCount, lottoNumbers.getMatchedCount(winningNumbers))) {
                matchCount++;
            }
        }

        return matchCount;
    }


    private boolean isMatched(int targetMatchCount, int matchedCount) {
        return targetMatchCount == matchedCount;
    }
}
