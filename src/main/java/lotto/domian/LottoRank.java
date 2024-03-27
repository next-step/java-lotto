package lotto.domian;

import java.util.Arrays;

public enum LottoRank {
    FIRST( 6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD( 5, 1_500_000),
    FOURTH( 4, 50_000),
    FIFTH( 3, 5_000),
    MISS(0, 0);

    private final int matchCount;
    private final int prizeMoney;

    LottoRank( int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank valueOfMatchCount(int matchCount, boolean matchBonus){
        if(matchCount == 5){
            return matchBonus ? SECOND : THIRD;
        }
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.getMatchCount() == matchCount)
                .filter(lottoRank -> lottoRank != SECOND && lottoRank != THIRD)
                .findFirst()
                .orElse(MISS);
    }

    public int getMatchCount() {
        return this.matchCount;
    }
    public int getPrizeMoney() { return this.prizeMoney;}

}
