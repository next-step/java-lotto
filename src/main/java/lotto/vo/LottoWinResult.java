package lotto.vo;

import lotto.enums.LottoRank;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoWinResult {
    private Map<LottoRank, Long> wins = new EnumMap<>(LottoRank.class);

    public LottoWinResult(List<LottoRank> lottoRanks) {
        lottoRanks.forEach(lottoRank -> {
            long lottoRankCount = getLottoRankCountOf(lottoRank);
            this.wins.put(lottoRank, lottoRankCount + 1);
        });
    }

    public long getLottoRankCountOf(LottoRank lottoRank) {
        Long lottoRankCount = this.wins.get(lottoRank);
        return ((null == lottoRankCount) ? 0 : lottoRankCount);
    }

    public Map<LottoRank, Long> getWins() {
        return Collections.unmodifiableMap(wins);
    }
}
