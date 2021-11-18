package lotto.domain;

import lotto.vo.LottoNumber;
import lotto.vo.Lottos;
import lotto.vo.Money;

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

    private final int rank;
    private final Money reward;
    private final long matchCount;

    WinningRank(int rank, int reward, long matchCount) {
        this.rank = rank;
        this.reward = Money.create(BigDecimal.valueOf(reward));
        this.matchCount = matchCount;
    }

    public static WinningRank valueOf(long matchCount) {
        return Arrays.stream(values())
                .filter(item -> item.matchCount == matchCount)
                .findFirst()
                .orElse(NO_RANK);
    }

    public static WinningRank getWinningRankWithLotto(Lotto lotto, Lotto winningLotto, LottoNumber bonus) {
        long countOfMatch = lotto.getCountOfMatch(winningLotto);
        WinningRank winningRank = valueOf(countOfMatch);
        if (countOfMatch == 5) {
            return getSecondOrThird(lotto, bonus);
        }

        return winningRank;
    }

    private static WinningRank getSecondOrThird(Lotto lotto, LottoNumber bonus) {
        if (lotto.containLottoNumber(bonus)) {
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

    public static List<WinningRank> checkWinning(Lottos lottos, Lotto winningLotto, LottoNumber bonus) {
        return lottos.getLottoList().stream()
                .map(lotto -> getWinningRankWithLotto(lotto, winningLotto, bonus))
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
