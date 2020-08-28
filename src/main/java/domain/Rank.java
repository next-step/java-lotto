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

    public static Rank getRank(Lotto lotto, WinningLotto winningLotto) {
        Set<LottoNumber> numbersInWinningLottoNumbers = lotto.getWinningNumbers(winningLotto);
        boolean matchBonus = lotto.isContainBonus(winningLotto);
        return Rank.valueOf(numbersInWinningLottoNumbers.size(), matchBonus);
    }

    protected static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch != 5) {
            return Arrays.stream(Rank.values())
                    .filter(rank -> rank.countOfMatch == countOfMatch)
                    .findFirst()
                    .orElse(MISS);
        }

        if (matchBonus) {
            return SECOND;
        }

        return THIRD;
    }

    public BigDecimal getWinningMoney() {
        return winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }
}
