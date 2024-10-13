package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoReward {
    FIRST_PLACE(2000000000, 6, "6개 일치 (2000000000원)"),
    SECOND_PLACE(30000000, 5, "5개 일치, 보너스 볼 일치(30000000원)"),
    THIRD_PLACE(1500000, 5, "5개 일치 (1500000원)"),
    FORTH_PLACE(50000, 4, "4개 일치 (50000원)"),
    FIFTH_PLACE(5000, 3, "3개 일치 (5000원)"),
    MISS(0, 0, "");

    private static final Map<Key, LottoReward> REWARD_MAP = createRewardHashMap();
    private final int reward;
    private final int matchCount;
    private final String description;

    LottoReward(int reward, int matchCount, String description) {
        this.reward = reward;
        this.matchCount = matchCount;
        this.description = description;
    }

    private static Map<Key, LottoReward> createRewardHashMap() {
        Map<Key, LottoReward> rewardMap = new HashMap<>();
        rewardMap.put(Key.valueOf(6, false), FIRST_PLACE);
        rewardMap.put(Key.valueOf(5, true), SECOND_PLACE);
        rewardMap.put(Key.valueOf(5, false), THIRD_PLACE);
        rewardMap.put(Key.valueOf(4, true), FORTH_PLACE);
        rewardMap.put(Key.valueOf(4, false), FORTH_PLACE);
        rewardMap.put(Key.valueOf(3, true), FIFTH_PLACE);
        rewardMap.put(Key.valueOf(3, false), FIFTH_PLACE);
        return rewardMap;
    }

    public static LottoReward valueOf(int matchCount, boolean matchBonus) {
        return REWARD_MAP.getOrDefault(Key.valueOf(matchCount, matchBonus), MISS);
    }

    public int getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getDescription() {
        return description;
    }

    private static class Key {
        private final int matchCount;
        private final boolean matchBonus;

        private Key(int matchCount, boolean matchBonus) {
            this.matchCount = matchCount;
            this.matchBonus = matchBonus;
        }

        private static Key valueOf(int matchCount, boolean matchBonus) {
            return new Key(matchCount, matchBonus);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return matchCount == key.matchCount && matchBonus == key.matchBonus;
        }

        @Override
        public int hashCode() {
            int result = Integer.hashCode(matchCount);
            result = 31 * result + Boolean.hashCode(matchBonus);
            return result;
        }
    }
}
