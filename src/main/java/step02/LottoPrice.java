package step02;

import static step02.LottoConfig.*;

public class LottoPrice {
    private final int buyPrice;

    public LottoPrice(int price) {
        Validation.checkMinPrice(price);
        this.buyPrice = price;
    }

    public static int calculationCount(LottoPrice price) {
        return price.buyPrice / LOTTO_PRICE;
    }

    public static double calculateTotalReward(LottoPrice price, LottoResultDTO lottoResultDTO) {
        int totalReward = 0;
        totalReward += RANK.calculate(RANK.FIRST.name(), lottoResultDTO.getMath6());
        totalReward += RANK.calculate(RANK.SECOND.name(), lottoResultDTO.getMath5());
        totalReward += RANK.calculate(RANK.THIRD.name(), lottoResultDTO.getMath4());
        totalReward += RANK.calculate(RANK.FOURTH.name(), lottoResultDTO.getMath3());

        return calculateYield(price.buyPrice, totalReward);
    }

    private static double calculateYield(int price, int totalReward) {
        return Math.round((totalReward / (double) price) * ONE_HUNDRED) / ONE_HUNDRED_D;
    }

}
