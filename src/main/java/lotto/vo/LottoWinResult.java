package lotto.vo;

import lotto.enums.LottoRank;

import java.util.EnumMap;
import java.util.Map;

public class LottoWinResult {
    private Map<LottoRank, Long> wins = new EnumMap<>(LottoRank.class);

    LottoWinResult(long[] matchCounts) {
        wins.put(LottoRank.FIRST, matchCounts[LottoRank.FIRST.getMatchCount()]);
        wins.put(LottoRank.SECOND, matchCounts[LottoRank.SECOND.getMatchCount()]);
        wins.put(LottoRank.THIRD, matchCounts[LottoRank.THIRD.getMatchCount()]);
        wins.put(LottoRank.FOURTH, matchCounts[LottoRank.FOURTH.getMatchCount()]);
    }

    long get(LottoRank lottoRank) {
        return wins.get(lottoRank);
    }
}
