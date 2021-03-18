package lotto.domain;

import java.util.Arrays;

public enum LottoRanking {
    FIRST(6, "2,000,000,000", 0),
    SECOND(5, "1,500,000", 0),
    THIRD(4, "50,000", 0),
    FOURTH(3, "5,000", 0);

    private final int correctCount;
    private final String price;
    private int count;

    LottoRanking(int correctCount, String price, int count) {
        this.correctCount = correctCount;
        this.price = price;
        this.count = count;
    }

    public void addCount() {
        this.count ++;
    }

    public static LottoRanking getLottoRaking(int correctCount) throws IllegalArgumentException {
        return Arrays.stream(LottoRanking.values())
                .filter(lottoRanking -> lottoRanking.correctCount == correctCount)
                .findFirst()
                .orElse(null);
    }

    public String getResultString() {
        return String.format("%d개 일치 (%d원)- %d개\n", this.correctCount, Integer.parseInt(this.price.replace(",", "")), this.count);
    }

    public long getResultMoney() {
        return Long.parseLong(this.price.replace(",", "")) * this.count;
    }

}

