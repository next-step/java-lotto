package lotto.prize;

import lotto.money.Money;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public enum LottoPrizeTemp {
    FIRST(6, 2_000_000_000, (matchCount, bonusMatch) -> matchCount == 6),
    SECOND(5, 30_000_000, (matchCount, bonusMatch) -> matchCount == 5 && bonusMatch),
    THIRD(5, 1_500_000, (matchCount, bonusMatch) -> matchCount == 5 && !bonusMatch),
    FOURTH(4, 50_000, (matchCount, bonusMatch) -> matchCount == 4),
    FIFTH(3, 5_000, (matchCount, bonusMatch) -> matchCount == 3),
    NONE(0, 0, (matchCount, bonusMatch) -> matchCount < 3);

    private final int matchCount;
    private final Money prizeMoney;
    private final BiFunction<Integer, Boolean, Boolean> judge;

    LottoPrizeTemp(int matchCount, int prizeMoney, BiFunction<Integer, Boolean, Boolean> judge) {
        this.matchCount = matchCount;
        this.prizeMoney = Money.from(prizeMoney);
        this.judge = judge;
    }

    public static LottoPrizeTemp of(int matchCount, boolean bonusMatch) {
        return Arrays.stream(LottoPrizeTemp.values())
                .filter(lottoPrize -> lottoPrize.judge.apply(matchCount, bonusMatch))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Illegal match info count " + matchCount + ", bonus match is" + bonusMatch));
    }

    public static List<LottoPrizeTemp> getWinningPrizes() {
        return Arrays.stream(LottoPrizeTemp.values())
                .filter(lottoPrize -> lottoPrize != NONE)
                .collect(Collectors.toList());
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money getPrizeMoney() {
        return prizeMoney;
    }
}
