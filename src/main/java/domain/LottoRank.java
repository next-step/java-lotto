package domain;

public class LottoRank {
    LottoRankAmount lottoRankAmount;

    public LottoRank(int matchCount, boolean withBonusYn) {
        LottoBonusState bonusState = getLottoBonusState(matchCount, withBonusYn);
        this.lottoRankAmount = getLottoRankAmount(matchCount, bonusState);
    }

    private LottoRankAmount getLottoRankAmount(int matchCount, LottoBonusState lottoBonusState) {
        if (matchCount == 3)
            return LottoRankAmount.FIFTH;

        if (matchCount == 4)
            return LottoRankAmount.FOURTH;

        if (matchCount == 5 && lottoBonusState == LottoBonusState.NO)
            return LottoRankAmount.THIRD;

        if (matchCount == 5 && lottoBonusState == LottoBonusState.YES)
            return LottoRankAmount.SECOND;

        if (matchCount == 6)
            return LottoRankAmount.FIRST;

        return LottoRankAmount.SIXTH;
    }

    LottoBonusState getLottoBonusState(int matchCount, boolean withBonusYn) {
        if (matchCount == 5 && withBonusYn == true)
            return LottoBonusState.NO;

        return LottoBonusState.YES;
    }

}
