package lotto.domain.enums;

import java.util.Arrays;

/**
 * 등수별 당첨 숫자 갯수
 */
public enum LottoRank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);


    private final int matchCount;
    private final int reward;
    private final boolean needBonus;

    LottoRank(int matchCount, int reward, boolean needBonus) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.needBonus = needBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public static LottoRank getLottoRank(int matchCount, boolean matchBonus) {

        if (isSecond(matchCount, matchBonus)){
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.needBonus && lottoRank.matchCount == matchCount)
                .findFirst().orElse(NONE);

    }

    private static boolean isSecond(int matchCount, boolean matchBonus){
        return SECOND.matchCount == matchCount && matchBonus;
    }
}
