package lotto.view;

import lotto.domain.BonusNumber;
import lotto.domain.NumberOfManualLottoToPurchase;
import lotto.domain.PurchaseAmountOfMoney;
import lotto.domain.WinningNumbers;
import lotto.domain.lotto.LottoNumber;
import lotto.exception.InvalidBonusNumberException;
import lotto.exception.InvalidNumberOfManualLottoToPurchase;
import lotto.exception.InvalidPurchaseAmountOfMoneyException;
import lotto.exception.InvalidWinningNumbersException;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.Validator.isNonBlank;
import static lotto.Validator.isPositiveInteger;

public class InputView {
    public static final String COMMA_BLANK_DELIMITER = ", ";
    private static final String PURCHASE_AMOUNT_OF_MONEY_INPUT_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_OF_MANUAL_LOTTO_TO_PURCHASE_GUIDE_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_GUIDE_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_GUIDE_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String NEXT_LINE = System.lineSeparator();
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {

    }

    public static PurchaseAmountOfMoney enteredPurchaseAmountOfMoney() {
        System.out.println(PURCHASE_AMOUNT_OF_MONEY_INPUT_GUIDE_MESSAGE);
        String purchaseAmountOfMoneyInput = SCANNER.nextLine();

        validatePurchaseAmountOfMoneyInput(purchaseAmountOfMoneyInput);

        return PurchaseAmountOfMoney.valueOf(Integer.parseInt(purchaseAmountOfMoneyInput));
    }

    private static void validatePurchaseAmountOfMoneyInput(String purchaseAmountOfMoneyInput) {
        if (!isPositiveInteger(purchaseAmountOfMoneyInput)) {
            throw new InvalidPurchaseAmountOfMoneyException(purchaseAmountOfMoneyInput);
        }
    }

    public static NumberOfManualLottoToPurchase enteredNumberOfManualLottoToPurchase(int maximumNumberOfManualLottoToPurchase) {
        String numberOfManualLottoToPurchaseGuideMessage = new StringBuilder()
                .append(NEXT_LINE)
                .append(NUMBER_OF_MANUAL_LOTTO_TO_PURCHASE_GUIDE_MESSAGE)
                .toString();

        System.out.println(numberOfManualLottoToPurchaseGuideMessage);
        String numberOfManualLottoToPurchaseInput = SCANNER.nextLine();

        validateNumberOfManualLottoToPurchaseInput(numberOfManualLottoToPurchaseInput);

        return NumberOfManualLottoToPurchase.newNumberOfManualLottoToPurchase(
                Integer.parseInt(numberOfManualLottoToPurchaseInput),
                maximumNumberOfManualLottoToPurchase);
    }

    private static void validateNumberOfManualLottoToPurchaseInput(String numberOfManualLottoToPurchaseInput) {
        if(!isPositiveInteger(numberOfManualLottoToPurchaseInput)) {
            throw new InvalidNumberOfManualLottoToPurchase(numberOfManualLottoToPurchaseInput);
        }
    }

    public static WinningNumbers enteredWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_GUIDE_MESSAGE);
        String winningNumbersInput = SCANNER.nextLine();

        validateWinningNumbersInput(winningNumbersInput);

        Set<LottoNumber> lottoNumbers = Arrays.stream(winningNumbersInput.split(COMMA_BLANK_DELIMITER))
                .map(number -> LottoNumber.valueOf(Integer.parseInt(number)))
                .collect(Collectors.toSet());

        return WinningNumbers.valueOf(lottoNumbers);
    }

    private static void validateWinningNumbersInput(String winningNumbersInput) {
        if (!isNonBlank(winningNumbersInput)) {
            throw InvalidWinningNumbersException.wrongFormat(winningNumbersInput);
        }

        boolean hasNonPositiveIntegerNumber = Arrays.stream(winningNumbersInput.split(COMMA_BLANK_DELIMITER))
                .anyMatch(number -> !isPositiveInteger(number));

        if (hasNonPositiveIntegerNumber) {
            throw InvalidWinningNumbersException.wrongFormat(winningNumbersInput);
        }
    }

    public static BonusNumber enteredBonusNumber(WinningNumbers winningNumbers) {
        System.out.println(BONUS_NUMBER_INPUT_GUIDE_MESSAGE);
        String bonusNumberInput = SCANNER.nextLine();

        validateBonusNumberInput(bonusNumberInput);

        LottoNumber bonusNumber = LottoNumber.valueOf(Integer.parseInt(bonusNumberInput));

        return BonusNumber.newBonusNumberWithOutWinningNumbers(bonusNumber, winningNumbers);
    }

    private static void validateBonusNumberInput(String bonusNumberInput) {
        if (!isPositiveInteger(bonusNumberInput)) {
            throw new InvalidBonusNumberException(bonusNumberInput);
        }
    }
}
