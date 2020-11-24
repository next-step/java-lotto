package lotto.service;

import lotto.domain.Pick;
import lotto.domain.PrizeInfo;
import lotto.domain.enums.Rank;

import java.util.Collection;

public abstract class AbstractPrizePackager {
    public PrizeInfo pack(){
        PrizeInfo prizeInfo = new PrizeInfo();
        prizeInfo.setPrizeChecker(this::makePrizeChecker);
        addPrize(prizeInfo);
        return prizeInfo;
    }

    protected abstract Rank makePrizeChecker(Pick pick, Collection<Integer> winningBalls);
    protected abstract void addPrize(PrizeInfo prizeInfo);
}
