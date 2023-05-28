package step2;

import java.util.Arrays;
import java.util.Optional;

public enum LottoMatch {
    //MISS(0,0, false)
    FIFTH(3, 5000, false)
    ,FOURTH(4, 50000, false)
    ,THIRD(5, 1500000, false)
    ,SECOND(5, 30000000, true)
    ,FIRST(6, 2000000000, false);

    private final int matchCount;
    private final int reward;
    private final boolean bonus;

    LottoMatch(int matchCount, int reward, boolean bonus) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.bonus = bonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public boolean getBonus() {
        return bonus;
    }

    public static LottoMatch valueOf(int count, boolean bonus) {
        return Arrays.stream(values())
                .filter(lottoMatch -> (lottoMatch.getMatchCount() == count))
                .filter(lottoMatch -> (lottoMatch.getBonus() == bonus))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Nothing Match"));
    }

}
