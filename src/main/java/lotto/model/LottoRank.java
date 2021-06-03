package lotto.model;

import java.util.Arrays;

public enum LottoRank {
    MATCH_COUNT_SIX(6, 2000000000, false),
    MATCH_COUNT_FIVE_AND_BONUS(5, 30000000, true),
    MATCH_COUNT_FIVE(5, 1500000, false),
    MATCH_COUNT_FOUR(4, 50000, false),
    MATCH_COUNT_THREE(3, 5000, false),
    MATCH_COUNT_TWO(2, 0, false),
    MATCH_COUNT_ONE(1, 0, false),
    MATCH_COUNT_ZERO(0, 0, false);

    private final int matchCount;
    private final int prize;
    private final boolean hasBonus;

    LottoRank(int matchCount, int prize, boolean hasBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.hasBonus = hasBonus;
    }

    public static LottoRank of(int matchCount, boolean hasBonus) {
        LottoRank matchingLottoRank = Arrays.stream(values())
                .filter(rank -> (rank.matchCount == matchCount))
                .findFirst()
                .orElseThrow(RuntimeException::new);
        if (matchingLottoRank.equals(LottoRank.MATCH_COUNT_FIVE) && hasBonus){
            return LottoRank.MATCH_COUNT_FIVE_AND_BONUS;
        }
        return matchingLottoRank;
    }

    public int getPrize(){
        return this.prize;
    }

    public int getMatchCount(){
        return this.matchCount;
    }

    public boolean hasBonus() {
        return this.hasBonus;
    }
}
