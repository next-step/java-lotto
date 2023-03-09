package domain;

public class LottoRank {
    LottoRankAmount lottoRankAmount;
    LottoBonusState lottoBonusState;

    public LottoRank(int matchCount, boolean withBonusYn) {
        // if (matchCount <= 2)
        // lottoRankAmount = LottoRankAmount.SIXTH;
        // if (matchCount == 3)
        // lottoRankAmount = LottoRankAmount.FIFTH;
        // if ()
        this.lottoBonusState = getLottoBonusState(matchCount, withBonusYn);
        this.lottoRankAmount = getLottoRankAmount(matchCount, this.lottoBonusState);
    }

    private LottoRankAmount getLottoRankAmount(int matchCount, LottoBonusState lottoBonusState) {
        if (matchCount == 3)
            return LottoRankAmount.FIFTH;

        if (matchCount == 4)
            return LottoRankAmount.THIRD;

        return LottoRankAmount.SIXTH;

    }

    LottoBonusState getLottoBonusState(int matchCount, boolean withBonusYn) {
        if (matchCount == 5 && withBonusYn == true)
            return LottoBonusState.NO;

        return LottoBonusState.YES;
    }

}
