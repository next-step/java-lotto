package lotto.service;

import lotto.domain.LottoBalls;
import lotto.domain.Pick;
import lotto.domain.PrizeInfo;
import lotto.domain.enums.Rank;

public abstract class AbstractPrizePackager {
    public PrizeInfo pack(){
        PrizeInfo prizeInfo = new PrizeInfo();
        prizeInfo.setPrizeChecker(this::makePrizeChecker);
        addPrize(prizeInfo);
        return prizeInfo;
    }

    protected abstract Rank makePrizeChecker(Pick pick, LottoBalls winningBalls);
    protected abstract void addPrize(PrizeInfo prizeInfo);
}
