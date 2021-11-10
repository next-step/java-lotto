package lotto.domain;

import lotto.vo.Money;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum WinningRank {

    FIRST_RANK(1, 2000000000, 6),
    SECOND_RANK(2, 1500000, 5),
    THIRD_RANK(3, 50000, 4),
    FOURTH_RANK(4, 5000, 3),
    NO_RANK(-1, 0, -1);

    private final int rank;
    private final Money reward;
    private final long matchCount;

    WinningRank(int rank, int reward, long matchCount) {
        this.rank = rank;
        this.reward = Money.create(reward);
        this.matchCount = matchCount;
    }

    public static WinningRank getWinningRankWithMatchCount(long matchCount) {
        return Arrays.stream(values())
                .filter(item -> item.matchCount == matchCount)
                .findFirst()
                .orElse(NO_RANK);
    }

    public static List<WinningRank> getReverseRankListWithoutNoRank() {
        return Arrays.stream(values())
                .filter(rank -> !rank.equals(WinningRank.NO_RANK))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public int getRank() {
        return rank;
    }

    public Money getReward() {
        return reward;
    }

    public long getMatchCount() {
        return matchCount;
    }
}
