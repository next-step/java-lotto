package lotto;

import java.util.Arrays;

public enum LottoRank {

    FIRST(2000000000, 6),
    SECOND(0, 0),
    THIRD(1500000, 5),
    FOURTH(50000, 4),
    FIFTH(5000, 3);

    private final int prize;
    private final int matchingNumbers;

    private LottoRank(int prize, int matchingNumbers) {
        this.prize = prize;
        this.matchingNumbers = matchingNumbers;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public static LottoRank determineRank(int matchingNumbers) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchingNumbers == matchingNumbers)
                .findFirst()
                .orElse(null);
    }
}
