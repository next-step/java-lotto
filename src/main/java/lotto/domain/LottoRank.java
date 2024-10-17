package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private long winningPrice;

    LottoRank(int countOfMatch, int winningPrice) {
        this.countOfMatch = countOfMatch;
        this.winningPrice = winningPrice;
    }

    public static LottoRank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == 5 && !matchBonus) {
            return THIRD;
        }

        return Arrays.stream(values())
                     .filter(lottoRank -> lottoRank.has(countOfMatch))
                     .findAny()
                     .orElse(MISS);
    }

    private boolean has(int count) {
        return count == countOfMatch;
    }

    public long getWinningPrice() {
        return winningPrice;
    }
}
