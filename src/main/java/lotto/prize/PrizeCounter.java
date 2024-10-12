package lotto.prize;

import lotto.number.LottoBalls;
import lotto.number.WinningNumbers;

import java.util.List;

public class PrizeCounter {

    private final List<LottoBalls> lottos;
    private final WinningNumbers winningNumbers;

    public PrizeCounter(List<LottoBalls> lottos, WinningNumbers winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
    }

    public PrizeCountMap countPrize() {
        PrizeCountMap prizeCountMap = new PrizeCountMap();

        lottos.forEach(lotto -> {
            int countMatchedNumber = winningNumbers.countMatchedNumber(lotto);
            boolean bonusNumberMatched = winningNumbers.isBonusNumberMatched(lotto);
            prizeCountMap.increasePrizeCount(countMatchedNumber, bonusNumberMatched);
        });

        return prizeCountMap;
    }
}
