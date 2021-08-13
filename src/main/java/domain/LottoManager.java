package domain;

public class LottoManager {

    private static final int LOTTO_PRICE = 1000;

    public static int getPurchaseLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
}
