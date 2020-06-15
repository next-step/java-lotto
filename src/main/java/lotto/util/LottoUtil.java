package lotto.util;

public class LottoUtil {
    private static final int LOTTO_PRICE = 1000;

    private LottoUtil() {}

    public static int calculateLottoQuantity(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public static void checkManualCount(int quantity, int manualCount) {
        if(manualCount > quantity){
            throw new IllegalArgumentException("구입 금액에 비해 수동 구매 장 수 가 많습니다.");
        }
    }
}
