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
            throw new IllegalArgumentException(String.format("최소 %d원 단위로 입력해 주세요.", MINIMUM_PRICE));
        }
    }

    public static void checkMaximumPurchasePrice(Integer purchasePrice) {
        if (purchasePrice > MAXIMUM_PRICE) {
            throw new IllegalArgumentException(String.format("인당 최대 %d원 까지 구매할 수 있습니다.", MAXIMUM_PRICE));
        }
    }

    public static void checkLottoNumberCount(Integer lottoCount) {
        if (!Objects.equals(LOTTO_NUMBER_COUNT, lottoCount)) {
            throw new IllegalArgumentException(String.format("숫자 %d개를 입력해 주세요.", LOTTO_NUMBER_COUNT));
        }
    }

    public static void checkMinimumCount(Integer manualCount) {
        if (manualCount < MINIMUM_MANUAL_COUNT) {
            throw new IllegalArgumentException(String.format("최소 %d이상 입력해 주세요.", MINIMUM_MANUAL_COUNT));
        }
    }

    public static boolean checkManualNumber(Integer manualNumber) {
        if (manualNumber < MINIMUM_NUMBER || manualNumber > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(String.format("%d-%d 사이의 숫자를 입력해 주세요.", MINIMUM_NUMBER, MAXIMUM_NUMBER));
        }
        return true;
    }

    public static void checkBonusNumber(List<Integer> winningLottoNumbers, Integer bonusNumber) {
        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스볼 숫자가 당첨번호와 중복입니다.");
        }
    }

    public static void checkManualLottoCount(Integer totalCount, Integer manualCount) {
        if (totalCount < manualCount) {
            throw new IllegalArgumentException("구입금액내에서 수동 갯수를 입력해주세요.");
        }
    }
}
