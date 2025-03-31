package lotto.domain.product;

import java.util.Arrays;

public enum LottoRank {
    SIX_MATCHES(6, 2_000_000_000) {
        @Override
        public boolean matches(int count, boolean bonus) {
            return count == 6;
        }
    },
    FIVE_BONUS(5, 30_000_000) {
        @Override
        public boolean matches(int count, boolean bonus) {
            return count == 5 && bonus;
        }
    },
    FIVE_MATCHES(5, 1_500_000) {
        @Override
        public boolean matches(int count, boolean bonus) {
            return count == 5 && !bonus;
        }
    },
    FOUR_MATCHES(4, 50_000) {
        @Override
        public boolean matches(int count, boolean bonus) {
            return count == 4;
        }
    },
    THREE_MATCHES(3, 5_000) {
        @Override
        public boolean matches(int count, boolean bonus) {
            return count == 3;
        }
    },
    NO_WIN(0, 0) {
        @Override
        public boolean matches(int count, boolean bonus) {
            return true;
        }
    };

    private final int matchCount;
    private final int prize;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public abstract boolean matches(int count, boolean bonus);

    public static LottoRank of(int matchCount, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.matches(matchCount, bonusMatch))
                .findFirst()
                .orElse(NO_WIN);
    }
}
