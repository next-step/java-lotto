package lotto.domain.prize;

import lotto.domain.money.Money;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoPrize {
    FIRST(6, Money.of(2_000_000_000)),
    SECOND(5, Money.of(1_500_000)),
    THIRD(4, Money.of(50_000)),
    FOURTH(3, Money.of(5_000)),
    NONE(0, Money.of(0));

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

    public static List<LottoPrize> getWinningPrizes() {
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize != NONE)
                .sorted((leftPrize, rightPrize) ->
                        Integer.compare(rightPrize.ordinal(), leftPrize.ordinal()))
                .collect(Collectors.toList());
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money getPrizeMoney() {
        return prizeMoney;
    }

    public int getPrizeMoneyAmount() {
        return prizeMoney.getAmount();
    }
}
