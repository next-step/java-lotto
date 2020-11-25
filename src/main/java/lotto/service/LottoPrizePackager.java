package lotto.service;

import lotto.domain.Cash;
import lotto.domain.Pick;
import lotto.domain.PrizeInfo;
import lotto.domain.WinningLottoBalls;
import lotto.domain.enums.Currency;
import lotto.domain.enums.Rank;

public class LottoPrizePackager extends AbstractPrizePackager {

    @Override
    public Rank makePrizeChecker(Pick pick, WinningLottoBalls winningBalls) {
        int count = pick.checkWinningBallCount(winningBalls.getWinningBalls());
        if (count >= 6) {
            return Rank.FIRST;
        }
        if (count >= 5 && pick.getBalls().contains(winningBalls.getBonusBall())) {
            return Rank.SECOND;
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
        prizeInfo.add(Rank.FIRST, new Cash(2000000000L, Currency.WON), "6개 일치");
        prizeInfo.add(Rank.SECOND, new Cash(30000000L, Currency.WON), "5개 일치, 보너스 볼 일치");
        prizeInfo.add(Rank.THIRD, new Cash(1500000L, Currency.WON), "5개 일치");
        prizeInfo.add(Rank.FOURTH, new Cash(50000L, Currency.WON), "4개 일치");
        prizeInfo.add(Rank.FIFTH, new Cash(5000L, Currency.WON), "3개 일치");
    }
}
