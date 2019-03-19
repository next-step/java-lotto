package lotto;

import java.util.Optional;

public enum Prize {

    FIRST(6) {
        public long calculatePrizeMoney(int count) {
            return count * FIRST_PRIZE_MONEY;
        }
    },

    SECONDE(5) {
        public long calculatePrizeMoney(int count) {
            return count * SECOND_PRIZE_MONEY;
        }
    },

    THIRD(4) {
        public long calculatePrizeMoney(int count) {
            return count * THIRD_PRIZE_MONEY;
        }
    },

    FORTH(3) {
        public long calculatePrizeMoney(int count) {
            return count * FORTH_PRIZE_MONEY;
        }
    };

    private static final int FIRST_PRIZE_MONEY = 2_000_000_000;
    private static final int SECOND_PRIZE_MONEY = 1500_000;
    private static final int THIRD_PRIZE_MONEY = 50_000;
    private static final int FORTH_PRIZE_MONEY = 5_000;

    private final int matchNumber;

    Prize(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    public abstract long calculatePrizeMoney(int count);

    public static Prize typeOf(int matchNumber) {
        Prize[] prizes = Prize.values();
        Prize result = null;

        for (Prize prize : prizes) {
            result = findPrize(result, prize, matchNumber);
        }

        return Optional.ofNullable(result).orElseThrow(IllegalArgumentException::new);
    }

    private static Prize findPrize(Prize result, Prize prize, int matchNumber) {
        if (prize.matchNumber == matchNumber) {
            result = prize;
        }
        return result;
    }

    public static long getPrizeMoney(int i) {
        return Prize.typeOf(i).calculatePrizeMoney(1);
    }
}
