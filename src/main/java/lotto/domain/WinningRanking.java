package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yusik on 2019/11/05.
 */
public enum WinningRanking {

    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false),
    ;

    private final int matchingCount;
    private final int reward;
    private final boolean matchingBonus;

    WinningRanking(int matchingCount, int reward, boolean matchingBonus) {
        this.matchingCount = matchingCount;
        this.reward = reward;
        this.matchingBonus = matchingBonus;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getReward() {
        return reward;
    }

    public boolean hasBonus() {
        return matchingBonus;
    }

    public boolean valuable() {
        return reward > 0;
    }

    public static WinningRanking valueOf(long matchingCount, boolean matchingBonus) {
        return Arrays.stream(WinningRanking.values())
                .filter(winningRanking -> winningRanking.matchingCount == matchingCount)
                .filter(winningRanking -> winningRanking.matchingBonus == matchingBonus)
                .findFirst()
                .orElse(MISS);
    }

    public static List<WinningRanking> sortedValues() {
        return Arrays.stream(values())
                .filter(WinningRanking::valuable)
                .sorted(Comparator.comparingInt(WinningRanking::getReward))
                .collect(Collectors.toList());
    }

}
