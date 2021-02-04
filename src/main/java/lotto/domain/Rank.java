package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    FIRST(2_000_000_000), SECOND(30_000_000), THIRD(1_500_000),
    FOURTH(50_000), FIFTH(5_000), NOTHING(0);

    private final int reward;

    Rank(int reward){
        this.reward = reward;
    }

    public static Rank getRank(int score, boolean hasBonus) {
        if (score == 6) { return Rank.FIRST; }
        if (score == 5 && hasBonus) { return Rank.SECOND; }
        if (score == 5) { return Rank.THIRD; }
        if (score == 4) { return Rank.FOURTH; }
        if (score == 3) { return Rank.FIFTH; }
        return Rank.NOTHING;
    }

    public int getReward(){
        return reward;
    }

    public static Map<Rank, Integer> getInitRankingDict() {
        Map<Rank, Integer> rankingStatus = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankingStatus.put(rank, 0);
        }
        return rankingStatus;
    }
}
