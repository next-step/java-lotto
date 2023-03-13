package domain;

import java.util.Arrays;

import domain.type.LottoBonusState;
import domain.type.LottoMatchCount;
import domain.type.LottoRankResult;

public class LottoRank {

    public static LottoRankResult getRank(Lotto lotto, FirstPlaceLotto firstPlaceLotto) {
        return getRank(lotto.matchCount(firstPlaceLotto), lotto.isHaveBonusNumer(firstPlaceLotto));
    }

    protected static LottoRankResult getRank(int matchCount, boolean withBonusYn) {
        return getLottoRankAmount(getLottoMatchCount(matchCount), getLottoBonusState(matchCount, withBonusYn));
    }

    protected static LottoRankResult getLottoRankAmount(LottoMatchCount matchCount, LottoBonusState lottoBonusState) {

        return Arrays.stream(LottoRankResult.values())
                .filter(it -> it.getMatchCount().equals(matchCount))
                .filter(it -> it.getBonusState().equals(lottoBonusState))
                .findFirst()
                .get();
    }

    protected static LottoMatchCount getLottoMatchCount(int matchCount) {
        return Arrays.stream(LottoMatchCount.values())
                .filter(it -> it.getMatchCount() == matchCount)
                .findFirst()
                .orElse(LottoMatchCount.ETC);
    }

    protected static LottoBonusState getLottoBonusState(int matchCount, boolean withBonusYn) {
        if (matchCount == 5 && withBonusYn == true)
            return LottoBonusState.YES;

        if (matchCount == 5 && withBonusYn == false)
            return LottoBonusState.NO;

        return LottoBonusState.ANY;
    }

}
