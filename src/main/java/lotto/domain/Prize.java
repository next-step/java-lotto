package lotto.domain;

import lotto.enums.WinningRank;

import java.util.Map;
import java.util.Objects;

public class Prize implements Comparable<Prize> {
    private static final int BOUND_MIN = 0;
    private static final String CHECK_PRIZE_BOUND = String.format("상금은 최소 %d원 이상이여야 합니다.", BOUND_MIN);
    private final int prize;

    public Prize(Map.Entry<WinningRank, Integer> rank) {
        this(rank.getKey().prize().prize() * rank.getValue());
    }

    public Prize(int prize) {
        validateBound(prize);
        this.prize = prize;
    }

    public int prize() {
        return prize;
    }

    private void validateBound(int prize) {
        if (BOUND_MIN > prize) {
            throw new IllegalArgumentException(CHECK_PRIZE_BOUND);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prize1 = (Prize) o;
        return prize == prize1.prize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize);
    }

    @Override
    public int compareTo(Prize o) {
        return prize() - o.prize();
    }
}
