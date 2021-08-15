package lottos.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoPrize {

    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    MISS(0, 0);

    private final int prizeAmount;
    private final int countOfMatches;

    LottoPrize(final int prizeAmount, final int countOfMatches) {
        this.prizeAmount = prizeAmount;
        this.countOfMatches = countOfMatches;
    }

    public static LottoPrize valueOf(final int countOfMatches, final boolean matchBonus) {
        if (isSecond(countOfMatches, matchBonus)) {
            return LottoPrize.SECOND;
        }
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> !prize.isBonus())
                .filter(prize -> prize.countOfMatches == countOfMatches)
                .findAny()
                .orElse(LottoPrize.MISS);
    }

    private static boolean isSecond(final int countOfMatches, final boolean matchBonus) {
        return SECOND.countOfMatches == countOfMatches && matchBonus;
    }

    public static List<LottoPrize> winningValues() {
        return Arrays.stream(LottoPrize.values())
                .filter(LottoPrize::isWinning)
                .sorted(Comparator.comparing(LottoPrize::getPrizeAmount))
                .collect(Collectors.toList());
    }

    public int getCountOfMatches() {
        return countOfMatches;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public boolean isWinning() {
        return this.prizeAmount > MISS.prizeAmount;
    }

    public boolean isBonus() {
        return this.equals(LottoPrize.SECOND);
    }
}
