package lotto.service;

import lotto.domain.PrizeInfo;
import lotto.domain.enums.Rank;

public class JackPotPrizePackager implements PrizePackager {
    @Override
    public PrizeInfo pack() {
        PrizeInfo prizeInfo = new PrizeInfo();
        prizeInfo.add(Rank.FIRST, 20000000000L);
        prizeInfo.setPrizeChecker((pick, winningBalls) -> Rank.FIRST);
        return prizeInfo;
    }
}
