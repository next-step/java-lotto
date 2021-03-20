package lotto.domain;

import java.util.Arrays;

public enum LottoRanking {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);

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

    public static LottoRanking lottoRanking(int correctCount) throws IllegalArgumentException {
        return Arrays.stream(LottoRanking.values())
                .filter(lottoRanking -> lottoRanking.correctCount == correctCount)
                .findFirst()
                .orElse(null);
    }

}

