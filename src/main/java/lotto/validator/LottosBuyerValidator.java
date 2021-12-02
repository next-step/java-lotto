package lotto.validator;

public class LottosBuyerValidator {
    public static void checkPurchaseValidation(int allLottosCount, int manualLottoCount) {
        if (allLottosCount - manualLottoCount < 0) {
            throw new IllegalArgumentException("전체 로또 수 보다, 수동 로또를 많이 구매할 수 없습니다.");
        }
    }
}
