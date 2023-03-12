package domain;

import java.util.Arrays;

import domain.type.LottoBonusState;
import domain.type.LottoMatchCount;
import domain.type.LottoRankAmount;

public class LottoRank {

    public static LottoRankAmount getRank(Lotto lotto, FirstPlaceLotto firstPlaceLotto) {

        return getRank(matchCount(lotto, firstPlaceLotto), withBonusYn(lotto, firstPlaceLotto));
    }

    protected static int matchCount(Lotto lotto, FirstPlaceLotto firstPlaceLotto) {
        return (int) lotto.getLottoNumbers().getNumbers().stream()
                .filter(it -> firstPlaceLotto.getLottoNumbers().getNumbers().contains(it))
                .count();
    }

    protected static boolean withBonusYn(Lotto lotto, FirstPlaceLotto firstPlaceLotto) {
        return lotto.getLottoNumbers().getNumbers().stream()
                .filter(it -> firstPlaceLotto.getBonusLottoNumber() == it)
                .count() == 1;
    }

    protected static LottoRankAmount getRank(int matchCount, boolean withBonusYn) {
        return getLottoRankAmount(getLottoMatchCount(matchCount), getLottoBonusState(matchCount, withBonusYn));
    }

    protected static LottoRankAmount getLottoRankAmount(LottoMatchCount matchCount, LottoBonusState lottoBonusState) {

        return Arrays.stream(LottoRankAmount.values())
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
