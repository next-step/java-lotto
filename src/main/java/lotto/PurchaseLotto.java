package lotto;

public class PurchaseLotto {
    private static final int LOTTO_PRICE = 1000;
    private int purchasedLottoCount;
    //private static InputAmount inputAmount;

    public PurchaseLotto(int inputAmount) {
        purchasedLottoCount = purchasingLottoCount(inputAmount);
    }

    public static int purchasingLottoCount(int amount) {
        return amount/LOTTO_PRICE;
    }
}
