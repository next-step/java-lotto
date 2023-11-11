package lotto.step2.util;

public class LottoProgramManager {
    public static int calculateNumberOfLottos(final int purchaseAmount, final int lottoPrice) {
        return purchaseAmount / lottoPrice;
    }
}
