package lotto.service;

import lotto.domain.Cash;
import lotto.domain.Pick;
import lotto.domain.PrizeInfo;
import lotto.domain.WinningLottoBalls;
import lotto.domain.enums.Currency;
import lotto.domain.enums.Rank;

public class DefaultPrizePackager extends AbstractPrizePackager {
    @Override
    protected Rank makePrizeChecker(Pick pick, WinningLottoBalls winningBalls) {
        return Rank.LOSE;
    }

    @Override
    protected void addPrize(PrizeInfo prizeInfo) {
        prizeInfo.add(Rank.LOSE,new Cash(0L, Currency.WON),"꽝 다음기회에");
    }
}
