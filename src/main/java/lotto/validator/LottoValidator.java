package lotto.validator;

import java.util.List;
import java.util.Objects;

import static lotto.rule.LottoRule.*;


public class LottoValidator {
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

    public static void checkMinimumCount(Integer manualCount) {
        if (manualCount < MINIMUM_MANUAL_COUNT) {
            throw new IllegalArgumentException("최소 0이상 입력해 주세요.");
        }
    }

    public static boolean checkManualNumber(Integer manualNumber) {
        if (manualNumber < MINIMUM_NUMBER || manualNumber > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("1-45 사이의 숫자를 입력해 주세요.");
        }
        return true;
    }

    public static void checkBonusNumber(List<Integer> winningLottoNumbers, Integer bonusNumber) {
        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스볼 숫자가 당첨번호와 중복입니다.");
        }
    }
}
