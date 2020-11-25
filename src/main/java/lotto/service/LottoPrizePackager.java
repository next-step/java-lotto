package lotto.service;

import lotto.domain.LottoBalls;
import lotto.domain.Pick;
import lotto.domain.PrizeInfo;
import lotto.domain.enums.Currency;
import lotto.domain.enums.Rank;

public class LottoPrizePackager extends AbstractPrizePackager {

    @Override
    public Rank makePrizeChecker(Pick pick, LottoBalls winningBalls) {
        int count = pick.checkWinningBallCount(winningBalls);
        if (count >= 6) {
            return Rank.FIRST;
        }
        if (count >= 5) {
            return Rank.THIRD;
        }
        if (count >= 4) {
            return Rank.FOURTH;
        }
        if (count >= 3) {
            return Rank.FIFTH;
        }
        return null;
    }

    @Override
    protected void addPrize(PrizeInfo prizeInfo) {
        prizeInfo.add(Rank.FIRST, 2000000000L, Currency.WON, "6개 일치");
        prizeInfo.add(Rank.THIRD, 1500000L, Currency.WON, "5개 일치");
        prizeInfo.add(Rank.FOURTH, 50000L, Currency.WON, "4개 일치");
        prizeInfo.add(Rank.FIFTH, 5000L, Currency.WON, "3개 일치");
    }
}
