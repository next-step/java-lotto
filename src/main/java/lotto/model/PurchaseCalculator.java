package lotto.model;

public class PurchaseCalculator {
    public static Integer LOTTERY_PRICE = 1000;

    public static int countPurchasable(int purchaseAmount) {
        return purchaseAmount / LOTTERY_PRICE;
    }
}
