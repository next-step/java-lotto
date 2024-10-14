package lotto.service;

public class LottoPurchaseService {
    public static final int PRICE_OF_LOTTO = 1000;

    public int calculateNumberOfLotto(int purchaseAmount) {
        checkIfCanPurchaseLotto(purchaseAmount);
        return purchaseAmount / PRICE_OF_LOTTO;
    }

    private static void checkIfCanPurchaseLotto(int totalAmount) {
        if (totalAmount < PRICE_OF_LOTTO) {
            throw new IllegalArgumentException("1000원 미만으론 살 수 없음");
        }
    }

}
