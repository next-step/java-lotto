package domain;

import java.util.Arrays;

import domain.type.LottoBonusState;
import domain.type.LottoMatchCount;
import domain.type.LottoRankAmount;

public class LottoRank {

    public static LottoRankAmount getRank(int matchCount, boolean withBonusYn) {
        return getLottoRankAmount(getLottoMatchCount(matchCount), getLottoBonusState(matchCount, withBonusYn));
    }

    private static LottoRankAmount getLottoRankAmount(LottoMatchCount matchCount, LottoBonusState lottoBonusState) {

        return Arrays.stream(LottoRankAmount.values())
                .filter(it -> it.getMatchCount().equals(matchCount))
                .filter(it -> it.getBonusState().equals(lottoBonusState))
                .findFirst()
                .get();
    }

    private static LottoMatchCount getLottoMatchCount(int matchCount) {
        return Arrays.stream(LottoMatchCount.values())
                .filter(it -> it.getMatchCount() == matchCount)
                .findFirst()
                .orElse(LottoMatchCount.ETC);
    }

    private static LottoBonusState getLottoBonusState(int matchCount, boolean withBonusYn) {
        if (matchCount == 5 && withBonusYn == true)
            return LottoBonusState.YES;

        if (matchCount == 5 && withBonusYn == false)
            return LottoBonusState.NO;

        return LottoBonusState.ANY;
    }

}
