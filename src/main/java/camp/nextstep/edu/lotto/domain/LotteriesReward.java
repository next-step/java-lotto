package camp.nextstep.edu.lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class LotteriesReward {
    private static final int COUNT_DEFAULT = 0;
    private static final int COUNT_UNIT = 1;
    private static final long IDENTITY_LONG = 0L;

    private final Map<RewardType, Integer> rewardMap;

    private LotteriesReward(Map<RewardType, Integer> rewardMap) {
        if (rewardMap == null) {
            throw new IllegalArgumentException("'rewardMap' must not be null");
        }
        this.rewardMap = new EnumMap<>(rewardMap);
    }

    public static LotteriesReward defaultInstance() {
        final Map<RewardType, Integer> rewardMap = new EnumMap<>(RewardType.class);
        rewardMap.put(RewardType.SIX_NUMBERS_MATCHED, COUNT_DEFAULT);
        rewardMap.put(RewardType.FIVE_NUMBERS_MATCHED, COUNT_DEFAULT);
        rewardMap.put(RewardType.FOUR_NUMBERS_MATCHED, COUNT_DEFAULT);
        rewardMap.put(RewardType.THREE_NUMBERS_MATCHED, COUNT_DEFAULT);
        return new LotteriesReward(rewardMap);
    }

    public void add(RewardType rewardType) {
        if (rewardType == null) {
            throw new IllegalArgumentException("'rewardType' must not be null");
        }
        final Integer previous = rewardMap.getOrDefault(rewardType, COUNT_DEFAULT);
        rewardMap.put(rewardType, previous + COUNT_UNIT);
    }

    public Set<Map.Entry<RewardType, Integer>> entrySet() {
        return rewardMap.entrySet();
    }

    public long sumAllRewards() {
        return rewardMap.entrySet()
                .stream()
                .map(entry -> entry.getKey().getReward() * entry.getValue())
                .reduce(IDENTITY_LONG, Long::sum);
    }

    @Override
    public String toString() {
        return "LotteriesReward{" +
                "rewardMap=" + rewardMap +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteriesReward that = (LotteriesReward) o;
        return rewardMap.equals(that.rewardMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewardMap);
    }
}
