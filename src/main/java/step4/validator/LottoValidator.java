package step4.validator;

import java.util.List;

public class LottoValidator {
    private static final int LOTTO_NUM_SIZE = 6;

    public static void validateLottoNum(List<Integer> nums) {
        if (nums.stream()
            .anyMatch(LottoValidator::notInRange)) {
            throw new RuntimeException("로또 번호는 1 ~ 45 사이의 번호여야 합니다");
        }

        if (nums.size() != LOTTO_NUM_SIZE) {
            throw new RuntimeException("로또 번호의 갯수는 6개여야 합니다");
        }
    }

    public static void validateBonusNum(int bonusNum) {
        if (notInRange(bonusNum)) {
            throw new RuntimeException("로또 번호는 1 ~ 45 사이의 번호여야 합니다");
        }
    }

    public static void validateMoney(int money) {
        if (isNotAvailableMoney(money)) {
            throw new RuntimeException("잘못된 금액을 입력하셨습니다.");
        }
    }

    public static void validateManualCount(int count) {
        if (isLottoCountNotAvailable(count)) {
            throw new RuntimeException("구매한 금액보다 더 많은 수동 로또를 입력하였습니다.");
        }
    }

    private static boolean notInRange(int num) {
        return num > 45 || num <= 0;
    }

    private static boolean isNotAvailableMoney(int money) {
        return money < 0;
    }

    private static boolean isLottoCountNotAvailable(int count) {
        return count < 0;
    }
}
