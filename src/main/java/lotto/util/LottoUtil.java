package lotto.util;

public class LottoUtil {

    public static final int LOTTO_PRICE = 1000;

    private LottoUtil() {

    }

    public static int getLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public static double getInvestment(long total, int purchaseAmount) {
        return (double) total / purchaseAmount;
    }
}
