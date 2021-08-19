package domain;

public class LottoPrice {

    public static final int LOTTO_PRICE = 1000;

    public static int purchaseLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

}
