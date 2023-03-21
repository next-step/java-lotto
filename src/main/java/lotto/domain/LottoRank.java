package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    MISS(0, 0, false),
    FOUR(3, 5000, false),
    TRHEE(4, 50000, false),
    TWO(5, 1500000, false),
    TWO_BONUS(5, 30000000, true),
    ONE(6, 2000000000, false);

    private final int matchingCount;
    private final int reward;
    private final boolean bonus;

    LottoRank(int matchingCount, int reward, boolean bonus) {
        this.matchingCount = matchingCount;
        this.reward = reward;
        this.bonus = bonus;
    }

    public int getMatchingCount() {
        return this.matchingCount;
    }

    public int getReward() {
        return this.reward;
    }

    public Boolean getBonus() {
        return this.bonus;
    }

    public static LottoRank getLottoRank(int matchingCount, Boolean bonus) {
        if (bonus == LottoRank.TWO_BONUS.getBonus()) {
            return LottoRank.TWO;
        }

        for (LottoRank rank : LottoRank.values()) {
            if (rank.getMatchingCount() == matchingCount) {
                return rank;
            }
        }
        return MISS;
    }
}
