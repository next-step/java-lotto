package domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FORTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final BigDecimal winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = new BigDecimal(winningMoney);
    }

    public static Rank getRank(LottoNumbers lottoNumbers, LottoNumbers lottoWinningNumbers) {
        Set<Number> numbersInWinningNumbers = lottoWinningNumbers.getContainNumbers(lottoNumbers);
        return findRankType(numbersInWinningNumbers.size());
    }

    protected static Rank findRankType(int hitNumber) {
        return Arrays.stream(Rank.values())
                .filter(e -> e.countOfMatch == hitNumber)
                .findFirst()
                .orElse(MISS);
    }

    public BigDecimal getWinningMoney() {
        return winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }
}
