package lotto.domain;

import lotto.LottoRankEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LottoResult {

    private final int MATCH_COUNT_BOUND = 2;
    private final int DEFAULT_COUNT = 0;
    private final int INCREASE_COUNT = 1;

    private final Map<LottoRankEnum, Integer> lottoResult;

    private LottoResult(Set<LottoNumbers> totalLottoNumbers, LottoNumbers winningLottoNumbers){
        lottoResult = new HashMap<>();

        for(LottoNumbers lottoNumbers : totalLottoNumbers){
            int matchCount = lottoNumbers.getMatchCount(winningLottoNumbers);

            setRankEnumByMatchCount(matchCount);
        }
    }
    public static LottoResult of(Set<LottoNumbers> totalLottoNumbers, LottoNumbers winningLottoNumbers){
        return new LottoResult(totalLottoNumbers, winningLottoNumbers);
    }

    private void setRankEnumByMatchCount(int matchCount) {
        if(matchCount > MATCH_COUNT_BOUND) {
            LottoRankEnum key = LottoRankEnum.valueOf(matchCount);
            lottoResult.put(key, lottoResult.getOrDefault(key, DEFAULT_COUNT) + INCREASE_COUNT);
        }
    }
    public Map<LottoRankEnum, Integer> getLottoResult(){
        return lottoResult;
    }
}
