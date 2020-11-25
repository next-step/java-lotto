package lotto.service;

import lotto.domain.Cash;
import lotto.domain.Pick;
import lotto.domain.PrizeInfo;
import lotto.domain.WinningLottoBalls;
import lotto.domain.enums.Currency;
import lotto.domain.enums.Rank;

public class JackPotPrizePackager extends AbstractPrizePackager {

    @Override
    protected Rank makePrizeChecker(Pick pick, WinningLottoBalls winningBalls) {
        return Rank.FIRST;
    }

    @Override
    protected void addPrize(PrizeInfo prizeInfo) {
        prizeInfo.add(Rank.FIRST, new Cash(20000000000L, Currency.WON), "Jack Pot!");
    }
}
