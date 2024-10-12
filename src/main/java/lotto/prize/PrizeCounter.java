package lotto.prize;

import lotto.number.LottoBalls;

import java.util.List;

public class PrizeCounter {

    private final List<LottoBalls> lottos;
    private final LottoBalls winningNumber;

    public PrizeCounter(List<LottoBalls> lottos, LottoBalls winningNumber) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
    }

    public PrizeCount countPrize() {
        PrizeCount prizeCount = new PrizeCount();

        lottos.forEach(lottoBalls -> {
            int matchedLottoNumbersCount = winningNumber.matchLottoBalls(lottoBalls);
            prizeCount.increasePrizeCount(matchedLottoNumbersCount);
        });

        return prizeCount;
    }
}
