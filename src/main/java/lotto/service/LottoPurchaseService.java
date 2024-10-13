package lotto.service;

public class LottoPurchaseService {
    public static final int PRICE_OF_LOTTO = 1000;

    public int calculateNumberOfLotto(int totalAmount) {
        return totalAmount / PRICE_OF_LOTTO;
    }

}
