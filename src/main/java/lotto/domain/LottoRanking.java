package lotto.domain;

import java.util.Arrays;

public enum LottoRanking {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int correctCount;
    private final int price;

    LottoRanking(int correctCount, int price) {
        this.correctCount = correctCount;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public static LottoRanking lottoRanking(int correctCount, boolean bonusBall) throws IllegalArgumentException {
        LottoRanking lottoRanking = Arrays.stream(LottoRanking.values())
                .filter(lotto -> !lotto.equals(LottoRanking.MISS))
                .filter(ranking -> ranking.correctCount == correctCount)
                .findFirst()
                .orElse(LottoRanking.MISS);

        if (lottoRanking.equals(LottoRanking.SECOND) && !bonusBall) {
            return LottoRanking.THIRD;
        }

        return lottoRanking;
    }

}

