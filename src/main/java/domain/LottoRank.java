package domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST_PRICE(6, 2_000_000_000),
    SECOND_PRICE(5, 3_000_000),
    THIRD_PRICE(5, 1_500_000),
    FOURTH_PRICE(4, 50_000),
    FIFTH_PRICE(3, 5_000),
    MISS(0, 0);

    private int combineNum;
    private int priceRewards;

    LottoRank(int combineNum, int priceRewards) {
        this.combineNum = combineNum;
        this.priceRewards = priceRewards;
    }

    public int getCombineNum() {
        return combineNum;
    }

    public int getPriceRewards() {
        return priceRewards;
    }

    public static LottoRank valueOf(int countOfMatch, boolean matchBonus) {
        LottoRank lottoRank = Arrays.stream(LottoRank.values())
                .filter(rank -> rank.combineNum == countOfMatch)
                .findFirst()
                .orElse(LottoRank.MISS);

        if (isSecondPrizeEquals(lottoRank) && !matchBonus) {
            return LottoRank.THIRD_PRICE;
        }
        return lottoRank;
    }

    private static boolean isSecondPrizeEquals(LottoRank lottoRank) {
        return lottoRank.equals(LottoRank.SECOND_PRICE);
    }
}
