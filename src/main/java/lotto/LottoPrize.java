package lotto;

import java.util.List;

public enum LottoPrize {
    FOURTH((lotto, targetList) -> (int) targetList.stream()
            .filter(target -> target.getCountMatchedLottoNumber(lotto) == 3)
            .count());

    LottoPrize(LottoPrizeStrategy lottoPrizeStrategy) {
        this.lottoPrizeStrategy = lottoPrizeStrategy;
    }

    private final LottoPrizeStrategy lottoPrizeStrategy;

    public int getMatchCount(Lotto prizeLotto, List<Lotto> targetLottos) {
        return lottoPrizeStrategy.getMatch(prizeLotto, targetLottos);
    }
}

