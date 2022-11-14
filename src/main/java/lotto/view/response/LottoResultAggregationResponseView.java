package lotto.view.response;

public class LottoResultAggregationResponseView {
    private static final String FORMAT = "%s개 일치 (%d원) - %d개";
    private static final String SECOND_PLACE_FORMAT = "%s개 일치, 보너스 볼 일치 (%d원) - %d개";
    private final int lottoRewardMatchCount;
    private final int lottoRewardAmount;
    private final int matchCount;
    private final boolean bonusBallMatched;

    public LottoResultAggregationResponseView(int lottoRewardMatchCount, int lottoRewardAmount, boolean bonusBallMatched, int matchCount) {
        this.lottoRewardMatchCount = lottoRewardMatchCount;
        this.lottoRewardAmount = lottoRewardAmount;
        this.bonusBallMatched = bonusBallMatched;
        this.matchCount = matchCount;
    }

    private String getFormat() {
        if (bonusBallMatched) {
            return SECOND_PLACE_FORMAT;
        }

        return FORMAT;
    }

    public String toView() {
        return String.format(getFormat(),
                this.lottoRewardMatchCount,
                lottoRewardAmount,
                this.matchCount);
    }
}
