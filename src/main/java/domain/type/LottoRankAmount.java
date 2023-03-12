package domain.type;

public enum LottoRankAmount {
    FIRST(1, LottoMatchCount.SIX, LottoBonusState.ANY, LottoRewardAmount.FIRST_REWARD),
    SECOND(2, LottoMatchCount.FIVE, LottoBonusState.YES, LottoRewardAmount.SECOND_REWARD),
    THIRD(3, LottoMatchCount.FIVE, LottoBonusState.NO, LottoRewardAmount.THIRD_REWARD),
    FOURTH(4, LottoMatchCount.FOUR, LottoBonusState.ANY, LottoRewardAmount.FIFTH_REWARD),
    FIFTH(5, LottoMatchCount.THREE, LottoBonusState.ANY, LottoRewardAmount.FIFTH_REWARD),
    ETC(6, LottoMatchCount.ETC, LottoBonusState.ANY, LottoRewardAmount.ETC_REWARD);

    private int rank;
    private LottoMatchCount matchCount;
    private LottoBonusState bonusState;
    private LottoRewardAmount amout;

    private LottoRankAmount(int rank, LottoMatchCount matchCount, LottoBonusState state, LottoRewardAmount amount) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.bonusState = state;
        this.amout = amount;
    }

    public LottoRewardAmount getAmount() {
        return this.amout;
    }

    public LottoMatchCount getMatchCount() {
        return this.matchCount;
    }

    public LottoBonusState getBonusState() {
        return this.bonusState;
    }

    public int getRank() {
        return this.rank;
    }
}
