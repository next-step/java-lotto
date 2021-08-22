package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public enum Rank {

    NOTHING(0, 0, (match, bonusMatch) -> match < 3),
    FIFTH(5_000, 3, (match, bonusMatch) -> match == 3),
    FOURTH(50_000, 4, (match, bonusMatch) -> match == 4),
    THIRD(1_500_000, 5, (match, bonusMatch) -> match == 5 && !bonusMatch),
    SECOND(30_000_000, 5, (match, bonusMatch) -> match == 5 && bonusMatch),
    FIRST(2_000_000_000, 6, (match, bonusMatch) -> match == 6);

    private int rewards;
    private int match;
    private BiPredicate<Integer, Boolean> matchFilter;

    Rank(int rewards, int match, BiPredicate<Integer, Boolean> matchFilter) {
        this.rewards = rewards;
        this.match = match;
        this.matchFilter = matchFilter;
    }

    static Rank findRank(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchFilter().test(countOfMatch, matchBonus))
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

    public BiPredicate<Integer, Boolean> getMatchFilter() {
        return matchFilter;
    }

}
