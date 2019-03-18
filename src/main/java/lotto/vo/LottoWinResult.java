package lotto.vo;

import lotto.enums.LottoRank;

import java.util.EnumMap;
import java.util.Map;

public class LottoWinResult {
    private Map<LottoRank, Long> wins = new EnumMap<>(LottoRank.class);

    LottoWinResult(long[] matchCounts) {
        LottoRank[] lottoRanks = LottoRank.values();

        for (LottoRank lottoRank : lottoRanks) {
            wins.put(lottoRank, matchCounts[lottoRank.getMatchCount()]);
        }
    }

    long get(LottoRank lottoRank) {
        return wins.get(lottoRank);
    }
}
