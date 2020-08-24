package nextstep.lotto.dto;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, false,2_000_000_000),
    SECOND(5, true,30_000_000),
    THIRD(5, false,1_500_000),
    FOURTH(4,false,50_000),
    FIFTH(3,false,5_000),
    MISS(0,false,0);

    private final int matchCount;
    private final boolean bonus;
    private final int reward;

    LottoRank(int matchCount, boolean bonus, int reward) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward(){
        return reward;
    }
    public static LottoRank of(int matchCount,boolean matchBonus) {

        return Arrays.stream(values())
                .filter(lottoRank -> (lottoRank.matchCount == matchCount) && (lottoRank.bonus == matchBonus))
                .findFirst()
                .orElse(MISS);
    }

}
