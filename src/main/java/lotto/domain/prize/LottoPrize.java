package lotto.domain.prize;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoPrize {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NOTHING(0, 0);

    private static final int BONUS_IN_LIST = 2;

    private final int match;
    private final long prize;
    private final boolean isBonus;

    LottoPrize(int match, long prize) {
        this(match, prize, false);
    }

    LottoPrize(int match, long prize, boolean isBonus) {
        this.isBonus = isBonus;
        this.match = match;
        this.prize = prize;
    }

    public static LottoPrize from(int match, boolean hasBonus) {
        List<LottoPrize> result = Stream.of(values())
                .filter(lottoPrize -> match == lottoPrize.getMatch())
                .collect(Collectors.toList());

        if (hasBonusWinningPrize(result.size())) {
            result.removeIf(lottoPrize -> isNotSame(lottoPrize.isBonus(), hasBonus));
        }

        return result.isEmpty() ? NOTHING : result.get(0);
    }

    private static boolean hasBonusWinningPrize(int size) {
        return size == BONUS_IN_LIST;
    }

    private static boolean isNotSame(boolean lottoPrizeBonus, boolean lottoBonus) {
        return lottoPrizeBonus ^ lottoBonus;
    }

    public long prize(int quantity) {
        return prize * quantity;
    }

    public int getMatch() {
        return match;
    }

    public long getPrize() {
        return prize;
    }

    public boolean isBonus() {
        return isBonus;
    }
}
