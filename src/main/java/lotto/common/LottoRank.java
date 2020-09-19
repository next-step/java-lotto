package lotto.common;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private int matchCount;
    private int reward;

    private static final Map<Integer, LottoRank> LOTTO_RANK_MAP;
    static {
        LOTTO_RANK_MAP = Arrays.stream(LottoRank.values())
                .collect(toMap(rank -> rank.matchCount, Function.identity()));
    }

    LottoRank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static LottoRank getRank(int matchCount) {
        return LOTTO_RANK_MAP.getOrDefault(matchCount, LottoRank.MISS);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
