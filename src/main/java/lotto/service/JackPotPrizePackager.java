package lotto.service;

import lotto.domain.Pick;
import lotto.domain.PrizeInfo;
import lotto.domain.enums.Currency;
import lotto.domain.enums.Rank;

import java.util.Collection;

public class JackPotPrizePackager extends AbstractPrizePackager {

    @Override
    protected Rank makePrizeChecker(Pick pick, Collection<Integer> winningBalls) {
        return Rank.FIRST;
    }

    @Override
    protected void addPrize(PrizeInfo prizeInfo) {
        prizeInfo.add(Rank.FIRST, 20000000000L, Currency.WON, "Jack Pot!");
    }
}
