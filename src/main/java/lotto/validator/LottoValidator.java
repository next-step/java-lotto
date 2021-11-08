package lotto.validator;

public class LottoValidator {
    private static final Integer MINIMUM_PRICE = 1_000;

    private LottoValidator() {
        throw new IllegalStateException("LottoValidator 직접 생성 금지");
    }

    public static void checkMinimumPurchasePrice(Integer purchasePrice) {
        if (purchasePrice < MINIMUM_PRICE || purchasePrice % MINIMUM_PRICE != 0) {
            throw new IllegalArgumentException("최소 1,000원 단위로 입력해 주세요.");
        }
    }
}
