package lotto.validator;

import java.util.Objects;

public class LottoValidator {
    private static final Integer MINIMUM_PRICE = 1_000;
    private static final Integer MAXIMUM_PRICE = 100_000;
    private static final Integer MINIMUM_NUMBER = 1;
    private static final Integer MAXIMUM_NUMBER = 45;
    private static final Integer LOTTO_NUMBER_COUNT = 6;

    private LottoValidator() {
        throw new IllegalStateException("LottoValidator 직접 생성 금지");
    }

    public static void checkMinimumPurchasePrice(Integer purchasePrice) {
        if (purchasePrice < MINIMUM_PRICE || purchasePrice % MINIMUM_PRICE != 0) {
            throw new IllegalArgumentException("최소 1,000원 단위로 입력해 주세요.");
        }
    }

    public static void checkMaximumPurchasePrice(Integer purchasePrice) {
        if (purchasePrice > MAXIMUM_PRICE) {
            throw new IllegalArgumentException("인당 최대 100,000원 까지 구매할 수 있습니다.");
        }
    }

    public static void checkLottoNumberCount(Integer lottoCount) {
        if (!Objects.equals(LOTTO_NUMBER_COUNT, lottoCount)) {
            throw new IllegalArgumentException("숫자 6개를 입력해 주세요.");
        }
    }

    public static boolean checkManualNumber(Integer manualNumber) {
        if (manualNumber < MINIMUM_NUMBER || manualNumber > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("1-45 사이의 숫자를 입력해 주세요.");
        }
        return true;
    }
}
