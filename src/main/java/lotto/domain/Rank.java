package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false),
    MISS(0,0, false)
    ;

    private final int matchCount;
    private final int prizeMoney;
    private final boolean hasBonus;

    Rank(int matchCount, int prizeMoney, boolean hasBonus) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.hasBonus = hasBonus;
    }

    public static Rank findByCountAndBonus(int matchCount, boolean hasBonus){
        Rank findRank = Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && !rank.hasBonus)
                .findFirst()
                .orElse(MISS);

        if (matchCount == Rank.SECOND.matchCount && hasBonus) {
            return Rank.SECOND;
        }

        return findRank;
    }
    
    public static List<Rank> successValues(){
        return Arrays.stream(values())
                .filter(rank -> !rank.equals(MISS))
                .collect(Collectors.toList());
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
