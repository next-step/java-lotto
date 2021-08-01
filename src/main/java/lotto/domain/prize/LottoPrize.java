package lotto.domain.prize;

import lotto.domain.money.Money;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoPrize {
    FIRST(6, Money.of(2_000_000_000), matchInfo -> matchInfo.isEqualCount(6)),
    SECOND_BONUS(5, Money.of(30_000_000), matchInfo -> matchInfo.isEqualCount(5) && matchInfo.isBonusNumberMatch()),
    SECOND(5, Money.of(1_500_000), matchInfo -> matchInfo.isEqualCount(5) && !matchInfo.isBonusNumberMatch()),
    THIRD(4, Money.of(50_000), matchInfo -> matchInfo.isEqualCount(4)),
    FOURTH(3, Money.of(5_000), matchInfo -> matchInfo.isEqualCount(3)),
    NONE(0, Money.of(0), matchInfo -> matchInfo.isUnderCount(3));

    private final int matchCount;
    private final Money prizeMoney;
    private final Function<MatchInfo, Boolean> judgementFunc;

    LottoPrize(int matchCount, Money prizeMoney, Function<MatchInfo, Boolean> judgementFunc) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.judgementFunc = judgementFunc;
    }

    public static LottoPrize of(MatchInfo matchInfo) {
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.judgementFunc.apply(matchInfo))
                .findFirst()
                .orElse(LottoPrize.NONE);
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
