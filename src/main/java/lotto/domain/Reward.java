package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Reward {
    private final static Map<Integer, Integer> rewardMap = initRewardMap();

    public static Map<Integer, Integer> getRewardMap() {
        return rewardMap;
    }

    // 3개 당첨 : 5000원
    // 4개 당첨 : 50000원
    // 5개 당첨 : 1500000원
    // 6개 당첨 : 2000000000원
    private static Map<Integer, Integer> initRewardMap(){
        Map<Integer, Integer> rewardMap = new HashMap<>();
        rewardMap.put(3, 5000);
        rewardMap.put(4, 50000);
        rewardMap.put(5, 1500000);
        rewardMap.put(6, 2000000000);
        return rewardMap;
    }
}
