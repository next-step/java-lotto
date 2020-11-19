package lotto.dto;

import lotto.domain.LottoRank;

public class PrintLottoResultValue {
    private final int matchCount;
    private final int reward;
    private final Long lottoCount;

    private PrintLottoResultValue(int matchCount, int reward, Long lottoCount) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.lottoCount = lottoCount;
    }

    public static PrintLottoResultValue of(LottoRank lottoRank, Long lottoCount) {
        return new PrintLottoResultValue(lottoRank.getMatchCount(),
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
