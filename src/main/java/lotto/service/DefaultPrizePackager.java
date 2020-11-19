package lotto.service;

import lotto.domain.PrizeInfo;
import lotto.domain.enums.Rank;

public class DefaultPrizePackager implements PrizePackager {
    @Override
    public PrizeInfo pack() {
        PrizeInfo prizeInfo = new PrizeInfo();
        prizeInfo.add(Rank.LOSE,0L);
        prizeInfo.setPrizeChecker((pick, winningBalls) -> Rank.LOSE);
        return prizeInfo;
    }
}
