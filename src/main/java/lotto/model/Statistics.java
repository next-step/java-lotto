package lotto.model;

public class Statistics {

    private static final int PRICE_OF_A_LOTTO = 1000;
    private static final int HUNDRED = 100;

    private final double totalPrice;
    private final double totalPrize;

    public Statistics(Ranks ranks) {
        this.totalPrice = ranks.calculateTotalLottoCount() * PRICE_OF_A_LOTTO;
        this.totalPrize = ranks.calculateTotalPrize();
    }

    public double calculateBenefits() {
        return Math.floor((totalPrize / totalPrice) * HUNDRED) / HUNDRED;
    }
}
