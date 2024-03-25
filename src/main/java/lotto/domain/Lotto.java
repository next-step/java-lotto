package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public void generateLottoNumbers(List<Integer> lottoNumber, int amount) {
        for (int i = 0; i < amount; i++) {
            LottoNumber newLottoNumber = new LottoNumber(lottoNumber);
            lottoNumbers.add(newLottoNumber);
        }
    }

    public void saveMatchResult(List<Integer> latestWinningNumbers, MatchCache matchCache, Profit profit) {
        this.lottoNumbers.forEach(iter -> {
            int matchCount = iter.cacheMatchCount(latestWinningNumbers);
            matchCache.save(matchCount);
            profit.accumulate(matchCount);
        });
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
