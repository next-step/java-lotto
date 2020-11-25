package util;

import java.util.Arrays;
import java.util.List;

public class LottoValidator {
    private static final String NUMBER_DELIMITER = ", ";
    private static final int LOTTO_LENGTH = 6;

    public static void checkDuplicateNumber(List<Integer> numbers) {
        long uniqueLength = numbers.stream()
                .distinct()
                .count();

        if(uniqueLength != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자를 가질 수 없습니다.");
        }
    }

    public static void checkWinningNumberValidate(String winningNumbers) {
        checkEmptyString(winningNumbers);
        String[] splitNumber = winningNumbers.split(NUMBER_DELIMITER);
        checkNumberLength(splitNumber);
        Arrays.stream(splitNumber)
                .map(Integer::new)
                .forEach(LottoValidator::checkLottoRange);
    }

    private static void checkEmptyString(String winningNumbers) {
        if(winningNumbers.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
        }
    }

    private static void checkNumberLength(String[] splitNumber) {
        if(splitNumber.length != 6) {
            throw new IllegalArgumentException("로또 숫자는 6개입니다.");
        }
    }

    public static void checkLottoRange(int number) {
        if(number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 범위는 1 ~ 45 입니다.");
        }
    }

    public static void checkUnitPrice(int priceTotal, int unitPrice) {
        if(priceTotal < unitPrice || priceTotal % unitPrice != 0) {
            throw new IllegalArgumentException("로또 금액 단위로 구매 가능합니다.");
        }
    }

    public static void checkBonusDuplicate(String winningNumbers, int bonusNumber) {
        for(String number : winningNumbers.split(NUMBER_DELIMITER)) {
            matchBonus(number, bonusNumber);
        }
    }

    private static void matchBonus(String number, int bonusNumber) {
        if(Integer.parseInt(number) == bonusNumber) {
            throw new IllegalArgumentException("보너스 번호가 정답로또와 중복됩니다.");
        }
    }

    public static void checkManualQuantity(int lottoQuantity, int manualQuantity) {
        if(lottoQuantity < manualQuantity) {
            throw new IllegalArgumentException("로또 금액보다 큰 개수입니다.");
        }
    }

    public static void checkManualDuplicate(String manualLotto) {
        long manualCount = Arrays.stream(manualLotto.split(NUMBER_DELIMITER))
                .distinct()
                .count();
        if(manualCount != LOTTO_LENGTH) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }
}
