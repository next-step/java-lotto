package lotto.prize;

import lotto.money.Money;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoPrizeTemp {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final Money prizeMoney;

    LottoPrizeTemp(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = Money.from(prizeMoney);
    }

    public static LottoPrizeTemp of(int matchCount, boolean bonusMatch) {
        return NONE;
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
