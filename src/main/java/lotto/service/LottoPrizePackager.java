package lotto.service;

import lotto.domain.Pick;
import lotto.domain.PrizeInfo;
import lotto.domain.enums.Currency;
import lotto.domain.enums.Rank;

import java.util.Collection;

public class LottoPrizePackager extends AbstractPrizePackager {

    @Override
    public Rank makePrizeChecker(Pick pick, Collection<Integer> winningBalls) {
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
        prizeInfo.add(Rank.FIRST, 2000000000L, Currency.WON);
        prizeInfo.add(Rank.THIRD, 1500000L, Currency.WON);
        prizeInfo.add(Rank.FOURTH, 50000L, Currency.WON);
        prizeInfo.add(Rank.FIFTH, 5000L, Currency.WON);
    }
}
