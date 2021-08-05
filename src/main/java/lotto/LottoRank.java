package lotto;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    OUT_OF_RANK(0, 0);

    private static final int FIVE = 5;

    private int countOfMatch;
    private int price;

    LottoRank(int countOfMatch, int price) {
        this.countOfMatch = countOfMatch;
        this.price = price;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getPrice() {
        return price;
    }

    public static LottoRank valueOf(int countOfMatch, boolean bonusMatch) {
        if (bonusMatch && countOfMatch == FIVE) {
            return SECOND;
        }
        if (!bonusMatch && countOfMatch == FIVE) {
            return THIRD;
        }
        return Arrays.stream(LottoRank.values())
                .filter(lottoRankEnum -> lottoRankEnum.getCountOfMatch() == countOfMatch)
                .findFirst()
                .orElse(OUT_OF_RANK);

    }
}
