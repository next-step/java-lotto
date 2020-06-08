package lotto.util;

public class LottoUtil {
    private static final int LOTTO_PRICE = 1000;

    private LottoUtil() {}

    public static int calculateLottoQuantity(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

}
