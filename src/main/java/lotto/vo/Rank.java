package lotto.vo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

public enum Rank {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 1_500_000),
    THIRD_PLACE(4, 50_000),
    FOURTH_PLACE(3, 5_000),
    FAILURE(0, 0);

    int numberOfMatches, reward;

    Rank(int numberOfMatches, int reward) {
        this.numberOfMatches = numberOfMatches;
        this.reward = reward;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public int getReward() {
        return reward;
    }

    static Rank valueOf(int matchCount) {
        if (matchCount < 3) {
            return FAILURE;
        }
        return Arrays.stream(values())
                .filter(v -> matchCount == v.numberOfMatches)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("error"));
    }

    public static int sumRevenue(Map<Rank, Integer> ranks){
        int sumRevenue = 0;
        if(ranks.containsKey(FIRST_PLACE)){
            sumRevenue = ranks.get(FIRST_PLACE) * FIRST_PLACE.getReward();
        } else if (ranks.containsKey(SECOND_PLACE)) {
            sumRevenue = ranks.get(SECOND_PLACE) * SECOND_PLACE.getReward();
        }else if(ranks.containsKey(THIRD_PLACE)){
            sumRevenue = ranks.get(THIRD_PLACE) * THIRD_PLACE.getReward();
        }else if(ranks.containsKey(FOURTH_PLACE)){
            sumRevenue = ranks.get(FOURTH_PLACE) * FOURTH_PLACE.getReward();
        }
        return sumRevenue;
    }
}
