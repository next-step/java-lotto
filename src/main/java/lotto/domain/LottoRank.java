package lotto.domain;

public enum LottoRank {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    MISS(0);

    private final int winningPrize;

    LottoRank(int winningPrize) {
        this.winningPrize = winningPrize;
    }

    public int winningPrize() {
        return winningPrize;
    }

    public static LottoRank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == 6) {
            return FIRST;
        }
        if (countOfMatch == 5) {
            if (matchBonus) {
                return SECOND;
            }
            return THIRD;
        }
        if (countOfMatch == 4) {
            return FOURTH;
        }
        if (countOfMatch == 3) {
            return FIFTH;
        }
        return MISS;
    }
}
