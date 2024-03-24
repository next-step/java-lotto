package lotto.model;

import java.util.Arrays;

public enum LottoRank {

    THREE_MATCHED(3,5000, "4등"),
    FOUR_MATCHED(4,50000, "3등"),
    FIVE_MATCHED(5,1500000, "2등"),
    SIX_MATCHED(6, 2000000000, "1등"),
    ;

    private final String rank;
    private final int matchCount;
    private final int price;

    LottoRank(int matchCount, int price , String rank) {
        this.matchCount = matchCount;
        this.price = price;
        this.rank = rank;
    }

    public int getMatchCount() { return this.matchCount;}
    public int getPrice() { return this.price;}
    public String getRank() { return rank;}

    public static int getPrice(int matchCount) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.getMatchCount() == matchCount)
                .findFirst()
                .map(LottoRank::getPrice)
                .orElse(0);
    }

    public static String getRank(int matchCount) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.getMatchCount() == matchCount)
                .findFirst()
                .map(LottoRank::getRank)
                .orElse(null);
    }

}
