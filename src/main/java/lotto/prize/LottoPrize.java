package lotto.prize;

import lotto.money.Money;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoPrize {
    FIRST(6, Money.init(2_000_000_000)),
    SECOND(5, Money.init(1_500_000)),
    THIRD(4, Money.init(50_000)),
    FOURTH(3, Money.init(5_000)),
    NONE(0, Money.init(0));

    private static final Map<Integer, LottoPrize> LOTTO_PRIZES = Arrays.stream(LottoPrize.values())
            .collect(Collectors.toMap(LottoPrize::getMatchCount, Function.identity()));

    private final int matchCount;
    private final Money prizeMoney;

    LottoPrize(int matchCount, Money prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoPrize of(int matchCount) {
        if (!LOTTO_PRIZES.containsKey(matchCount)) {
            return NONE;
        }

        return LOTTO_PRIZES.get(matchCount);
    }

    private int getMatchCount() {
        return matchCount;
    }
}
