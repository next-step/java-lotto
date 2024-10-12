package lotto.domain.prize;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum LottoPrize {

    FIRST(6, 2_000_000_000),
    SECOND_WITH_BONUS(5, 30_000_000, true),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NOTHING(0, 0);

    private static final Map<Integer, Prize> LOTTO_PRIZES;
    private static final int NOTHING_INDEX = 0;

    private final int match;
    private final long prize;
    private final boolean isBonus;

    static {
        LOTTO_PRIZES = new HashMap<>();
        for (LottoPrize lottoPrize : values()) {
            Optional.ofNullable(LOTTO_PRIZES.putIfAbsent(lottoPrize.match, new Prize(lottoPrize)))
                    .ifPresent(prize -> prize.save(lottoPrize.isBonus, lottoPrize));
        }
    }

    LottoPrize(int match, long prize) {
        this(match, prize, false);
    }

    LottoPrize(int match, long prize, boolean isBonus) {
        this.isBonus = isBonus;
        this.match = match;
        this.prize = prize;
    }

    public static LottoPrize from(int match, boolean hasBonus) {
        Prize prize = LOTTO_PRIZES.getOrDefault(match, LOTTO_PRIZES.get(NOTHING_INDEX));
        if (!hasBonus) {
            return prize.nonBonus;
        }
        return prize.bonus;
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

    private static class Prize {

        private LottoPrize nonBonus;
        private LottoPrize bonus;

        private Prize(LottoPrize init) {
            nonBonus = init;
            bonus = init;
        }

        private void save(boolean hasBonus, LottoPrize lottoPrize) {
            if (hasBonus) {
                bonus = lottoPrize;
                return;
            }
            nonBonus = lottoPrize;
        }
    }
}
