package lottery;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum LotteryPlace {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final Integer matchCnt;
    private final int reward;

    LotteryPlace(Integer matchCnt, Integer reward) {
        this.matchCnt = matchCnt;
        this.reward = reward;
    }

    public Integer getMatchCnt() {
        return matchCnt;
    }

    public Integer getReward() {
        return reward;
    }

    public static LotteryPlace fromMatchCnt(Integer matchCnt, Boolean bonusHit) {
        if (matchCnt == 5) {
            return getPlaceIf5MatchesBasedOnBonusHit(bonusHit);
        }
        return getPlaceIfNot5Matches(matchCnt);
    }

    private static LotteryPlace getPlaceIf5MatchesBasedOnBonusHit(Boolean bonusHit) {
        if (bonusHit) return SECOND;
        return THIRD;
    }

    private static LotteryPlace getPlaceIfNot5Matches(Integer matchCnt) {
        var matchCntToPlaceMap = Arrays.stream(values())
                .filter(place -> place.getMatchCnt() != 5)
                .collect(Collectors.toMap(LotteryPlace::getMatchCnt, place -> place));
        return matchCntToPlaceMap.getOrDefault(matchCnt, MISS);
    }
}
