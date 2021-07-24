package lotto.prize;

import lotto.money.Money;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoPrize {
    FIRST(6, 2_000_000_000, (matchInfo) -> matchInfo.isCountEqual(6)),
    SECOND(5, 30_000_000, (matchInfo) -> matchInfo.isCountEqual(5) && matchInfo.isBonusMatch()),
    THIRD(5, 1_500_000, (matchInfo) -> matchInfo.isCountEqual(5) && !matchInfo.isBonusMatch()),
    FOURTH(4, 50_000, (matchInfo) -> matchInfo.isCountEqual(4)),
    FIFTH(3, 5_000, (matchInfo) -> matchInfo.isCountEqual(3)),
    NONE(0, 0, (matchInfo) -> matchInfo.isCountUnder(3));

    private final int matchCount;
    private final Money prizeMoney;
    private final Function<MatchInfo, Boolean> judge;

    LottoPrize(int matchCount, int prizeMoney, Function<MatchInfo, Boolean> judge) {
        this.matchCount = matchCount;
        this.prizeMoney = Money.from(prizeMoney);
        this.judge = judge;
    }

    public static LottoPrize of(int matchCount, boolean bonusMatch) {
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.judge.apply(MatchInfo.of(matchCount, bonusMatch)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Illegal match info count " + matchCount + ", bonus match is" + bonusMatch));
    }

    public static LottoPrize evaluate(MatchInfo matchInfo) {
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.judge.apply(matchInfo))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Illegal match info"));
    }

    public static List<LottoPrize> getWinningPrizes() {
        return Arrays.stream(LottoPrize.values())
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
