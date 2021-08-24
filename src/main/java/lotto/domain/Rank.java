package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public enum Rank {

    NOTHING(0, 0, false),
    FIFTH(5_000, 3, false),
    FOURTH(50_000, 4, false),
    THIRD(1_500_000, 5, false),
    SECOND(30_000_000, 5, true),
    FIRST(2_000_000_000, 6, false);

    private int rewards;
    private int match;
    private boolean matchBonus;

    Rank(int rewards, int match, boolean matchBonus) {
        this.rewards = rewards;
        this.match = match;
        this.matchBonus = matchBonus;
    }

    static Rank findRank(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> countOfMatch < 3 || rank.match == countOfMatch)
                .filter(rank -> rank.match != 5 || matchBonus && rank.matchBonus)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("맞는 랭크가 없습니다."));
    }

    public static List<Rank> valuesExcludeNoRewards() {
        return Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.NOTHING))
                .collect(Collectors.toList());
    }

    public int getMatch() {
        return match;
    }

    public int getRewards() {
        return rewards;
    }

}
