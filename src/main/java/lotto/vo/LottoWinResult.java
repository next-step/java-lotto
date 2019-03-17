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

    long getFirst() {
        return wins.get(LottoRank.FIRST);
    }

    long getSecond() {
        return wins.get(LottoRank.SECOND);
    }

    long getThird() {
        return wins.get(LottoRank.THIRD);
    }

    long getFourth() {
        return wins.get(LottoRank.FOURTH);
    }
}
