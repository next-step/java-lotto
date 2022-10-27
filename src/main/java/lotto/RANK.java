package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum RANK {

    THREE(3, new Money(5000)),
    FOUR(4, new Money(50000)),
    FIVE(5, new Money(1500000)),
    FIVE_BONUS(5, new Money(30_000_000)),
    SIX(6, new Money(2000000000)),
    ;

    private final int countOfMatch;
    private final Money winningMoney;

    RANK(int countOfMatch, Money winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public Money getWinningMoney() {
        return winningMoney;
    }

    public static Optional<RANK> findWinningPrize(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(winningPrize -> winningPrize.countOfMatch == countOfMatch)
                .filter(winningPrize -> {
                    if (winningPrize == FIVE) {
                        return !matchBonus;
                    }
                    if (winningPrize == FIVE_BONUS) {
                        return matchBonus;
                    }
                    return true;
                })
                .findFirst();
    }

    public static Map<RANK, Integer> getEmptyRanks() {
        Map<RANK, Integer> ranks = new HashMap<>();
        for (RANK rank : values()) {
            ranks.put(rank, 0);
        }
        return ranks;
    }

}
