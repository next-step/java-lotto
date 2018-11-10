package domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST_PRICE(6, 2_000_000_000),
    SECOND_PRICE(5, 1_500_000),
    THIRD_PRICE(4, 50_000),
    FOURTH_PRICE(3, 5_000),
    MISS(0, 0);

    private int combineNum;
    private int priceRewards;

    LottoRank(int combineNum, int priceRewards) {
        this.combineNum = combineNum;
        this.priceRewards = priceRewards;
    }

    public int getPriceRewards() {
        return priceRewards;
    }

    public static int findByCombineNum(int combineNum) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.combineNum == combineNum)
                .findFirst()
                .orElse(LottoRank.MISS)
                .getPriceRewards();
    }
}
