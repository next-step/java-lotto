package lotto.view;

import lotto.domain.BonusNumber;
import lotto.domain.PurchaseAmountOfMoney;
import lotto.domain.WinningNumbers;
import lotto.domain.lotto.LottoNumber;
import lotto.exception.InValidBonusNumberException;
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
    private static final String WINNING_NUMBERS_INPUT_GUIDE_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_GUIDE_MESSAGE = "보너스 볼을 입력해 주세요.";
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
        if(!isPositiveInteger(purchaseAmountOfMoneyInput)) {
            throw new InvalidPurchaseAmountOfMoneyException(purchaseAmountOfMoneyInput);
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
        if(!isNonBlank(winningNumbersInput)) {
            throw InvalidWinningNumbersException.wrongFormat(winningNumbersInput);
        }

        boolean hasNonPositiveIntegerNumber = Arrays.stream(winningNumbersInput.split(COMMA_BLANK_DELIMITER))
                .anyMatch(number -> !isPositiveInteger(number));

        if(hasNonPositiveIntegerNumber) {
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
        if(!isPositiveInteger(bonusNumberInput)) {
            throw new InValidBonusNumberException(bonusNumberInput);
        }
    }
}
