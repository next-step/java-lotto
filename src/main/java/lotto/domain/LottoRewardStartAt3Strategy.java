package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoRewardStartAt3Strategy implements LottoRewardStrategy {
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;

    private static final int THREE_REWARD = 5000;
    private static final int FOUR_REWARD = 50000;
    private static final int FIVE_REWARD = 1500000;
    private static final int SIX_REWARD = 2000000000;

    @Override
    public Map<Integer, Integer> getReward() {
        Map<Integer, Integer> reward = new HashMap<>();
        reward.put(THREE, THREE_REWARD);
        reward.put(FOUR, FOUR_REWARD);
        reward.put(FIVE, FIVE_REWARD);
        reward.put(SIX, SIX_REWARD);

        return reward;
    }
}
