package camp.nextstep.edu.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LotteriesReward {
    private static final long IDENTITY_LONG = 0L;
    private static final Set<RewardType> WINNING_TYPE_SET;

    static {
        WINNING_TYPE_SET = new HashSet<>(
                Arrays.asList(
                        RewardType.SIX_NUMBERS_MATCHED,
                        RewardType.FIVE_NUMBERS_AND_BONUS_MATCHED,
                        RewardType.FIVE_NUMBERS_MATCHED,
                        RewardType.FOUR_NUMBERS_MATCHED,
                        RewardType.THREE_NUMBERS_MATCHED
                )
        );
    }

    private final Map<RewardType, Integer> rewardMap;

    private LotteriesReward(Map<RewardType, Integer> rewardMap) {
        if (rewardMap == null) {
            throw new IllegalArgumentException("'rewardMap' must not be null");
        }
        this.rewardMap = new EnumMap<>(rewardMap);
    }

    public static LotteriesReward from(List<RewardType> rewardTypes) {
        final Map<RewardType, Integer> rewardMap = WINNING_TYPE_SET.stream()
                .collect(Collectors.toMap(
                        rewardType -> rewardType,
                        rewardType -> LotteriesReward.count(rewardTypes, rewardType)
                ));
        return new LotteriesReward(rewardMap);
    }

    private static int count(List<RewardType> rewardTypes, RewardType rewardType) {
        return (int) rewardTypes.stream()
                .filter(type -> type == rewardType)
                .count();
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
