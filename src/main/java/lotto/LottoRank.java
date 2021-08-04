package lotto;

import lotto.exception.InvalidLottoRankException;

import java.util.Arrays;

public enum LottoRank {
    ALL_MATCH(6, 2_000_000_000),
    FIVE_MATCH_WITH_BONUS(5, 30_000_000),
    FIVE_MATCH(5, 1_500_000),
    FOUR_MATCH(4, 50_000),
    THREE_MATCH(3, 5_000),
    OUT_OF_RANK(0, 0);

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

    public static LottoRank valueOf(int countOfMatch) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRankEnum -> lottoRankEnum.getCountOfMatch() == countOfMatch)
                .findFirst()
                .orElse(OUT_OF_RANK);
    }
}
