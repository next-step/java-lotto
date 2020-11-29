package my.project.lotto.domain;

import com.sun.javafx.css.Rule;

import java.util.Arrays;

/**
 * Created : 2020-11-27 오후 4:34
 * Developer : Seo
 */
public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(5, 50_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5000),
    NO_RANK(0, 0);

    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank rank(int matchCount, boolean matchBonus) {
        if (matchCount > FIRST.matchCount) {
            throw new IllegalArgumentException("");
        }
        if (SECOND.matchCount(matchCount) && matchBonus) {
            return SECOND;
        }
        if (THIRD.matchCount(matchCount) && !matchBonus) {
            return THIRD;
        }
        if (matchCount < FIFTH.matchCount) {
            return NO_RANK;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.matchCount(matchCount))
                .findFirst()
                .orElse(NO_RANK);
    }

    private boolean matchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public int getPrize() {
        return this.prize;
    }

}
