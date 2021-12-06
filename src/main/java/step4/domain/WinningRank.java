package step4.domain;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum WinningRank {

    FIRST_RANK(1, 2_000_000_000, 6),
    SECOND_RANK(2, 30_000_000, 5),
    THIRD_RANK(3, 1_500_000, 5),
    FOURTH_RANK(4, 50_000, 4),
    FIFTH_RANK(5, 5_000, 3),
    NO_RANK(-1, 0, -1);

    private static final int CHECK_SECOND_OR_THIRD_COUNT = 5;
    private final int rank;
    private final Money reward;
    private final long matchCount;

    WinningRank(int rank, int reward, long matchCount) {
        this.rank = rank;
        this.reward = Money.of(BigDecimal.valueOf(reward));
        this.matchCount = matchCount;
    }

    public static WinningRank valueOf(long matchCount) {
        return Arrays.stream(values())
                .filter(item -> item.matchCount == matchCount)
                .findFirst()
                .orElse(NO_RANK);
    }

    private static WinningRank rank(Lotto lotto, WinningLotto winningLotto) {
        long countOfMatch = winningLotto.countOfMatch(lotto);
        WinningRank winningRank = valueOf(countOfMatch);
        if (countOfMatch == CHECK_SECOND_OR_THIRD_COUNT) {
            return getSecondOrThird(lotto, winningLotto);
        }

        return winningRank;
    }

    private static WinningRank getSecondOrThird(Lotto lotto, WinningLotto winningLotto) {
        if (winningLotto.hasBonus(lotto)) {
            return WinningRank.SECOND_RANK;
        }

        return WinningRank.THIRD_RANK;
    }

    public static List<WinningRank> getReverseRankListWithoutNoRank() {
        return Arrays.stream(values())
                .filter(rank -> !rank.equals(WinningRank.NO_RANK))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static List<WinningRank> findWinningRanks(Lottos lottos, WinningLotto winningLotto) {
        return lottos.getLottos().stream()
                .map(lotto -> rank(lotto, winningLotto))
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
