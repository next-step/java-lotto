package lotto.domain;

import java.util.Arrays;

public enum LottoRanking {
    FIRST(6, "2,000,000,000"),
    SECOND(5, "1,500,000"),
    THIRD(4, "50,000"),
    FOURTH(3, "5,000");

    private final int correctCount;
    private final String price;

    LottoRanking(int correctCount, String price) {
        this.correctCount = correctCount;
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public static LottoRanking lottoRanking(int correctCount) throws IllegalArgumentException {
        return Arrays.stream(LottoRanking.values())
                .filter(lottoRanking -> lottoRanking.correctCount == correctCount)
                .findFirst()
                .orElse(null);
    }

    public String resultString(int count) {
        return String.format("%d개 일치 (%d원)- %d개\n", this.correctCount, Integer.parseInt(this.price.replace(",", "")), count);
    }


}

