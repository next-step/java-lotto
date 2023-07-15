package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000) {
        @Override
        protected boolean check(final int match, final boolean isContainBonus) {
            return super.check(match, isContainBonus) && !isContainBonus;
        }
    },
    SECOND(5, 30_000_000) {
        @Override
        protected boolean check(final int match, final boolean isContainBonus) {
            return super.check(match, isContainBonus) && isContainBonus;
        }
    },
    FIRST(6, 2_000_000_000),
    NONE(0, 0);

    private final int match;
    private final long prize;

    LottoRank(final int match, final long prize) {
        this.match = match;
        this.prize = prize;
    }

    public static LottoRank from(final int match, final boolean isContainBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.check(match, isContainBonus))
                .findAny()
                .orElse(NONE);
    }

    protected boolean check(int match, boolean isContainBonus) {
        return this.match == match;
    }

    public long getPrize() {
        return prize;
    }

    public int getMatch() {
        return match;
    }
}
