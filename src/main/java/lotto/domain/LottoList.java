package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoList {

    private List<Lotto> lottoList;

    public LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    @Override
    public String toString() {
        String lottoListStr = "";
        for (Lotto lotto : lottoList) {
            lottoListStr += "[";
            lottoListStr += lotto.toString();
            lottoListStr += "]\n";
        }
        return lottoListStr.trim();
    }


    public Map<LottoRank,Integer> makeMatchingCount(List<LottoNumber> lastWeekWinningLotto) {
        Map<LottoRank,Integer> matchingCountMap = new HashMap<>();
        for ( Lotto lotto : lottoList) {
            int matchingCount = lotto.containsCount(lastWeekWinningLotto);
            LottoRank rank = LottoRank.findByMatchingCount(matchingCount);
            if(LottoRank.isMiss(rank)) {
                continue;
            }
            matchingCountMap.put(rank, matchingCountMap.getOrDefault(rank,0) + 1);
        }

        return matchingCountMap;

    }
}
