package lotto.enums;

import java.util.Map;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < 3) {
            return MISS;
        }
        if (countOfMatch == 3) {
            return FIFTH;
        }
        if (countOfMatch == 4) {
            return FOURTH;
        }
        if (countOfMatch == 5 && !matchBonus) {
            return THIRD;
        }
        if (countOfMatch == 5) {
            return SECOND;
        }
        if (countOfMatch == 6) {
            return FIRST;
        }
        throw new IllegalStateException("적합하지 않은 숫자입니다.");
    }

    public void applyMatchCount(Map<Rank, Integer> matchMap) {
        matchMap.put(this, matchMap.getOrDefault(this, 0) + 1);
    }
}
