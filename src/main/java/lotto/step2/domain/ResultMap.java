package lotto.step2.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultMap {
    private static final Map<MatchNumber, Integer> resultMap = new HashMap<>();
    private static final int THREE_MATCH_REWARD = 5000;
    private static final int FOUR_MATCH_REWARD = 50000;
    private static final int FIVE_MATCH_REWARD = 1_500_000;
    private static final int SIX_MATCH_REWARD = 2_000_000_000;
    
    static {
        resultMap.put(MatchNumber.THREE, THREE_MATCH_REWARD);
        resultMap.put(MatchNumber.FOUR, FOUR_MATCH_REWARD);
        resultMap.put(MatchNumber.FIVE, FIVE_MATCH_REWARD);
        resultMap.put(MatchNumber.SIX, SIX_MATCH_REWARD);
    }
    
    public int totalReward(List<MatchNumber> matchNumbers) {
        return matchNumbers.stream()
                .mapToInt(resultMap::get)
                .sum();
    }
}
