package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.exception.InputValueException;
import lotto.util.StringUtils;

import java.util.List;
import java.util.Scanner;

public final class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER_PATTERN = ", ";
    private static final int MIN_PURCHASE_AMOUNT = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private InputView() {
    }

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = SCANNER.nextLine();

        validateBlank(purchaseAmount);

        int amount = StringUtils.toInt(purchaseAmount);
        validatePurchaseAmount(amount);

        return amount;
    }

    private static void validateBlank(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new InputValueException("데이터를 입력하세요.");
        }
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < MIN_PURCHASE_AMOUNT) {
            throw new InputValueException("구입금액을 1000원보다 작게 입력할 수 없습니다.");
        }
    }

    public static List<Integer> getLastWeekLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String lottoNumbers = SCANNER.nextLine();

        validateBlank(lottoNumbers);

        return LottoNumbers.createNonDuplicateNumbers(lottoNumbers);
    }

    public static int getBonusNumber(LottoNumbers lastWinLottoNumbers) {
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumber = SCANNER.nextLine();

        validateBlank(bonusNumber);

        int number = StringUtils.toInt(bonusNumber);

        validateBonusNumber(number, lastWinLottoNumbers);

        return number;
    }

    public static void validateBonusNumber(int bonusNumber, LottoNumbers lastWinLottoNumbers) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new InputValueException("보너스 번호는 1 ~ 45 까지 입력 가능합니다.");
        }

        if (lastWinLottoNumbers.isMatchNumber(bonusNumber)) {
            throw new InputValueException("당첨 번호에 포함된 번호를 입력할 수 없습니다.");
        }
    }
}
