package lotto.view.response;

import lotto.model.LottoReward;

public class LottoResultAggregationResponseView {
    private static final String FORMAT = "%s개 일치 (%d원) - %d개";
    private static final String SECOND_PLACE_FORMAT = "%s개 일치, 보너스 볼 일치 (%d원) - %d개";
    private final LottoReward lottoReward;
    private final int matchCount;

    public LottoResultAggregationResponseView(LottoReward lottoReward, int matchCount) {
        this.lottoReward = lottoReward;
        this.matchCount = matchCount;
    }

    private String getFormat() {
        if (this.lottoReward == LottoReward.SECOND_PLACE) {
            return SECOND_PLACE_FORMAT;
        }

        return FORMAT;
    }

    public String toView() {
        return String.format(getFormat(),
                this.lottoReward.getMatchCount(),
                this.lottoReward.getRewardAmount(),
                this.matchCount);
    }
}
