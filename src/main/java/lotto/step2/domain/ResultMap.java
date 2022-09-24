package lotto.step2.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultMap {
    private static final Map<MatchNumber, Integer> resultMap = new HashMap<>();
    
    static {
        resultMap.put(MatchNumber.THREE, 5000);
        resultMap.put(MatchNumber.FOUR, 50000);
        resultMap.put(MatchNumber.FIVE, 1_500_000);
        resultMap.put(MatchNumber.SIX, 2_000_000_000);
    }
    
    
    public int totalReward(List<MatchNumber> matchNumbers) {
        return matchNumbers.stream()
                .mapToInt(resultMap::get)
                .sum();
    }
}
