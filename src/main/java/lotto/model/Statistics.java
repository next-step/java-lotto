package lotto.model;

public class Statistics {

    private static final int PRICE_OF_A_LOTTO = 1000;
    private static final int HUNDRED = 100;

    private final double totalPrice;
    private final double totalPrize;

    public Statistics(int lottoAmount, double totalPrize) {
        this.totalPrice = lottoAmount * PRICE_OF_A_LOTTO;
        this.totalPrize = totalPrize;
    }

    public double calculateBenefits() {
        return Math.floor((totalPrize / totalPrice) * HUNDRED) / HUNDRED;
    }
}
