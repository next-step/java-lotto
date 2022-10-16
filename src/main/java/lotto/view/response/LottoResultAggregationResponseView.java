package lotto.view.response;

import lotto.model.LottoReward;

public class LottoResultAggregationResponseView {
    private static final String FORMAT = "%s개 일치 (%d원) - %d개";
    private final LottoReward lottoReward;
    private final int matchCount;

    public LottoResultAggregationResponseView(LottoReward lottoReward, int matchCount) {
        this.lottoReward = lottoReward;
        this.matchCount = matchCount;
    }

    public String toView() {
        return String.format(FORMAT,
                this.lottoReward.getMatchCount(),
                this.lottoReward.getRewardAmount(),
                this.matchCount);
    }
}
