package lotto.service;

public class RewardRateCalculator {

    private RewardRateCalculator(){}

    public static double countRewardRate(int winnerPriceSum, int buyPrice) {
        return Math.round(winnerPriceSum / (double) buyPrice);
    }
}
