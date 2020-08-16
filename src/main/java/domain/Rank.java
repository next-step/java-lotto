package domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Set;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FORTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final BigDecimal winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = new BigDecimal(winningMoney);
    }

    public static Rank getType(LottoNumbers lottoNumbers, LottoNumbers lottoWinningNumbers, Number bonusNumber) {
        Set<Number> numbersInWinningNumbers = lottoWinningNumbers.getContainNumbers(lottoNumbers);
        boolean matchBonus = lottoNumbers.isContainBonus(bonusNumber);
        return Rank.valueOf(numbersInWinningNumbers.size(), matchBonus);
    }

    protected static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == 5) {
            return matchBonus? SECOND : THIRD;
        }

        return Arrays.stream(Rank.values())
                .filter(e -> e.countOfMatch == countOfMatch)
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
