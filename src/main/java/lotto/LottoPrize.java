package lotto;

import java.util.Arrays;
import java.util.List;

public enum LottoPrize {
    FOURTH(5000L, (lotto, targetList) -> (int) targetList.stream()
            .filter(target -> target.getCountMatchedLottoNumber(lotto) == 3)
            .count()),
    THIRD(50000L, (lotto, targetList) -> (int) targetList.stream()
            .filter(target -> target.getCountMatchedLottoNumber(lotto) == 4)
            .count()),
    SECOND(1500000L, (lotto, targetList) -> (int) targetList.stream()
            .filter(target -> target.getCountMatchedLottoNumber(lotto) == 5)
            .count()),
    FIRST(2000000000L, (lotto, targetList) -> (int) targetList.stream()
            .filter(target -> target.getCountMatchedLottoNumber(lotto) == 6)
            .count());


    LottoPrize(Long prize, LottoPrizeStrategy lottoPrizeStrategy) {
        this.prize = prize;
        this.lottoPrizeStrategy = lottoPrizeStrategy;
    }

    private final Long prize;
    private final LottoPrizeStrategy lottoPrizeStrategy;

    public Long getMatchCount(Lotto prizeLotto, List<Lotto> targetLottos) {
        return lottoPrizeStrategy.getMatch(prizeLotto, targetLottos);
    }

    public static long getPrizeSum(Lotto prizeLotto, List<Lotto> targetLottoList) {
        return Arrays.stream(values())
                .mapToLong(item -> {
                    long match = item.lottoPrizeStrategy.getMatch(prizeLotto, targetLottoList);
                    return item.prize * match;
                }).sum();
    }

}

