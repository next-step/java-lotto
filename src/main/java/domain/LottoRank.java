package domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST_PRICE (6 ,2000000000),
    SECOND_PRICE(5 ,1500000),
    THIRD_PRICE (4 ,50000),
    FOURTH_PRICE(3 ,5000);

    private int combineNum;
    private int priceRewards;

    LottoRank(int combineNum, int priceRewards){
        this.combineNum = combineNum;
        this.priceRewards = priceRewards;
    }

    public int getPriceRewards() {
        return priceRewards;
    }

    public static int findByCombineNum(int combineNum){
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.combineNum == combineNum)
                .findFirst()
                .get()
                .getPriceRewards();
    }
}
