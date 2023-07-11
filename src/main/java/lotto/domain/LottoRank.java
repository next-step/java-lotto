package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6L, 2_000_000_000L),
    SECOND(5L, 30_000_000L) {
        @Override
        protected boolean verify(Long match, boolean isContainBonus) {
            return super.verify(match, isContainBonus) && isContainBonus;
        }
    },
    THIRD(5L, 1_500_000L) {
        @Override
        protected boolean verify(Long match, boolean isContainBonus) {
            return super.verify(match, isContainBonus) && !isContainBonus;
        }
    },
    FOURTH(4L, 50_000L),
    FIFTH(3L, 5_000L),
    NONE(0L, 0L);


    private final Long match;
    private final Long prize;

    LottoRank(Long match, Long prize) {
        this.match = match;
        this.prize = prize;
    }

    public static LottoRank from(Long match, boolean isContainBonus) {
        return Arrays.stream(values())
            .filter(rank -> rank.verify(match, isContainBonus))
            .findAny()
            .orElse(NONE);
    }

    protected boolean verify(Long match, boolean isContainBonus) {
        return this.match.equals(match);
    }

    public Long getPrize() {
        return prize;
    }

    public Long getMatch() {
        return match;
    }
}
