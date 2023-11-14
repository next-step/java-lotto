package lotto.application;

import lotto.domain.LottoRank;
import lotto.domain.Lottos;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoPlay {
    Map<LottoRank, Integer> matchMap;

    public LottoPlay(Lottos lottos, List<Integer> winList) {
        this.matchMap = lottos.findMatchNumbers(winList);
    }

    public Long sumMatch() {
        Long result = 0L;
        for (LottoRank lottoRank : matchMap.keySet()) {
            result += lottoRank.sumPrize(matchMap.get(lottoRank));
        }
        return result;
    }

    public Map<LottoRank, Integer> findMatchResult() {
        Map<LottoRank, Integer> resultMap = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : LottoRank.values()) {
            addMap(lottoRank, resultMap);
        }
        return resultMap;
    }

    private void addMap(LottoRank lottoRank, Map<LottoRank, Integer> resultMap) {
        if (lottoRank.matchNumber() > 2) {
            resultMap.put(lottoRank, matchMap.getOrDefault(lottoRank, 0));
        }
    }
}
