package step4.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final Map<RankHashKey, Rank> RANKS = Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(RankHashKey::new, Function.identity())));

    private int countOfMatch;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        return RANKS.getOrDefault(new RankHashKey(countOfMatch, matchBonus), Rank.MISS);
    }

    private static class RankHashKey {

        private final int countOfMatch;
        private final boolean matchBonus;

        RankHashKey(Rank rank) {
            this.countOfMatch = rank.countOfMatch;
            this.matchBonus = rank.equals(Rank.SECOND);
        }

        RankHashKey(int countOfMatch, boolean matchBonus) {
            this.countOfMatch = countOfMatch;
            this.matchBonus = matchBonus;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RankHashKey that = (RankHashKey) o;
            return countOfMatch == that.countOfMatch &&
                    matchBonus == that.matchBonus;
        }

        @Override
        public int hashCode() {
            return Objects.hash(countOfMatch, matchBonus);
        }

    }

}
