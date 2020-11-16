package lotto.dto;

import lotto.domain.LottoRank;

public class LottoStatisticsValue {
    private final int matchCount;
    private final int reward;
    private final Long lottoCount;

    private LottoStatisticsValue(int matchCount, int reward, Long lottoCount) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.lottoCount = lottoCount;
    }

    public static LottoStatisticsValue of(LottoRank lottoRank, Long lottoCount) {
        return new LottoStatisticsValue(lottoRank.getMatchCount(),
                                        lottoRank.getReward(),
                                        lottoCount);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public Long getLottoCount() {
        return lottoCount;
    }
}
