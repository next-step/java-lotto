package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6L),
    SECOND(5L) {
        @Override
        protected boolean verify(Long match, boolean isContainBonus) {
            return super.verify(match, isContainBonus) && isContainBonus;
        }
    },
    THIRD(5L) {
        @Override
        protected boolean verify(Long match, boolean isContainBonus) {
            return super.verify(match, isContainBonus) && !isContainBonus;
        }
    },
    FOURTH(4L),
    FIFTH(3L),
    NONE(0L);


    private final Long match;

    LottoRank(Long match) {
        this.match = match;
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
}
