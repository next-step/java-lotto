package lotto.service;

import lotto.domain.Pick;
import lotto.domain.PrizeInfo;
import lotto.domain.enums.Rank;

import java.util.Collection;

public class DefaultPrizePackager extends AbstractPrizePackager {
    @Override
    protected Rank makePrizeChecker(Pick pick, Collection<Integer> winningBalls) {
        return Rank.LOSE;
    }

    @Override
    protected void addPrize(PrizeInfo prizeInfo) {
        prizeInfo.add(Rank.LOSE,0L);
    }
}
