package lotto.domain;

public enum LottoRank {
    FIRST,
    SECOND,
    THIRD,
    FOURTH,
    FIFTH,
    MISS;

    public int winningPrize() {
        return 0;
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
