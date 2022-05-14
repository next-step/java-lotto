package lotto.view;

import lotto.domain.Cash;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.exception.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String MESSAGE_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";
    private static final String MESSAGE_LAST_WINNING_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static final String MESSAGE_MANUAL_LOTTO_COUNT = "수동으로 로매할 로또 수를 입력해 주세요.";
    private static final String MESSAGE_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String MESSAGE_INVALID_NUMBER_FORMAT = "숫자만 입력 가능합니다.";
    private static final String MESSAGE_INVALID_BONUS_BALL = "당첨 번호와 동일합니다. 다른 보너스 번호를 입력해주세요.";
    private static final int EMPTY_COUNT = 0;

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
        throw new NotSupportInstanceException();
    }

    public static Cash purchaseAmountView() {
        System.out.println(MESSAGE_PURCHASE_AMOUNT);
        return inputValidPurchaseAmount();
    }

    private static Cash inputValidPurchaseAmount() {
        try {
            return inputPurchaseAmount();
        } catch (InvalidCash e) {
            System.out.println(e.getMessage());
            return inputValidPurchaseAmount();
        }
    }

    private static Cash inputPurchaseAmount() {
        return new Cash(inputInt());
    }

    public static int manualLottoCountView(int totalCount) {
        System.out.println(MESSAGE_MANUAL_LOTTO_COUNT);
        return inputValidManualLottoCount(totalCount);
    }

    private static int inputValidManualLottoCount(int totalCount) {
        try {
            return inputManualLottoCount(totalCount);
        } catch (InvalidManualLottoNumberCount e) {
            System.out.println(e.getMessage());
            return inputValidManualLottoCount(totalCount);
        }
    }

    private static int inputManualLottoCount(int totalCount) {
        int count = inputInt();
        if (count > totalCount) {
            throw new InvalidManualLottoNumberCount(totalCount);
        }
        return count;
    }

    public static List<LottoNumbers> manualLottoNumbersView(int manualLottoCount) {
        if (manualLottoCount == EMPTY_COUNT) {
            return Collections.emptyList();
        }
        System.out.println(MESSAGE_MANUAL_LOTTO_NUMBERS);
        return inputValidManualLottoNumbers(manualLottoCount, new ArrayList<>());
    }

    private static List<LottoNumbers> inputValidManualLottoNumbers(int manualLottoCount, List<LottoNumbers> manualLottoNumbers) {
        try {
            return inputManualLottoNumbers(manualLottoCount, manualLottoNumbers);
        } catch (InvalidLottoNumberCount | InvalidBoundLottoNumber e) {
            System.out.println(e.getMessage());
            return inputValidManualLottoNumbers(manualLottoCount, manualLottoNumbers);
        } catch (NumberFormatException ne) {
            System.out.println(MESSAGE_INVALID_NUMBER_FORMAT);
            return inputValidManualLottoNumbers(manualLottoCount, manualLottoNumbers);
        }
    }

    private static List<LottoNumbers> inputManualLottoNumbers(int manualLottoCount, List<LottoNumbers> manualLottoNumbers) {
        while (manualLottoNumbers.size() < manualLottoCount) {
            String value = scanner.nextLine();
            manualLottoNumbers.add(new LottoNumbers(value));
        }
        return manualLottoNumbers;
    }

    private static int inputInt() {
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public static LottoNumbers lastWinningLottoNumberView() {
        System.out.println(MESSAGE_LAST_WINNING_LOTTO_NUMBER);
        return inputValidLastWinningLottoNumber();
    }

    private static LottoNumbers inputValidLastWinningLottoNumber() {
        try {
            return inputLastWinningLottoNumber();
        } catch (InvalidLottoNumberCount | InvalidBoundLottoNumber e) {
            System.out.println(e.getMessage());
            return inputValidLastWinningLottoNumber();
        } catch (NumberFormatException ne) {
            System.out.println(MESSAGE_INVALID_NUMBER_FORMAT);
            return inputValidLastWinningLottoNumber();
        }
    }

    private static LottoNumbers inputLastWinningLottoNumber() {
        return new LottoNumbers(scanner.nextLine());
    }

    public static LottoNumber bonusBallView(LottoNumbers lastWinningLottoNumbers) {
        System.out.println(MESSAGE_BONUS_BALL);
        return inputValidBonusBall(lastWinningLottoNumbers);
    }

    private static LottoNumber inputValidBonusBall(LottoNumbers lastWinningLottoNumbers) {
        try {
            return inputBonusBall(lastWinningLottoNumbers);
        } catch (NumberFormatException ne) {
            System.out.println(MESSAGE_INVALID_NUMBER_FORMAT);
            return inputValidBonusBall(lastWinningLottoNumbers);
        } catch (InvalidBoundLottoNumber | IllegalArgumentException be) {
            System.out.println(be.getMessage());
            return inputValidBonusBall(lastWinningLottoNumbers);
        }
    }

    private static LottoNumber inputBonusBall(LottoNumbers lastWinningLottoNumbers) {
        LottoNumber bonusNumber = LottoNumber.valueOf(inputInt());
        if (lastWinningLottoNumbers.isContain(bonusNumber)) {
            throw new IllegalArgumentException(MESSAGE_INVALID_BONUS_BALL);
        }
        return bonusNumber;
    }
}
