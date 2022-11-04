package automaticlotto.view;

import automaticlotto.automaticexception.ExceptionCommand;
import automaticlotto.automaticexception.InputValueException;

import java.util.Scanner;

import static automaticlotto.automaticexception.ExceptionCommand.PRICE_EXCEPTION_MESSAGE;

public class InputView {

    private static final int LOTTO_PRICE_MIN = 1;
    private static final Scanner sc = new Scanner(System.in);

    private InputView() {

    }

    public static int enterPurchaseAmount() {
        System.out.println("구입금액을 입력해주세요.");
        int purchaseAmount = Integer.parseInt(sc.nextLine());
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE_MIN) {
            throw new InputValueException(PRICE_EXCEPTION_MESSAGE);
        }
    }

    public static String[] splitWinningNumbers() {
        String winningNumber = enterWinningNumber();
        winningNumber = winningNumber.trim();
        String[] winningNumbers = winningNumber.split(",");
        validateNumberWinningNumbers(winningNumbers.length);
        return winningNumbers;
    }

    private static String enterWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumber = sc.nextLine();
        validateWinningNumber(winningNumber);
        return winningNumber;
    }

    private static void validateWinningNumber(String winningNumber) {
        if (winningNumber == null || winningNumber.isBlank()) {
            throw new InputValueException(ExceptionCommand.NULL_EXCEPTION_MESSAGE);
        }
    }

    private static void validateNumberWinningNumbers(int winningNumberCount) {
        if (winningNumberCount != 6) {
            throw new InputValueException(ExceptionCommand.NUMBER_WINNING_NUMBERS_EXCEPTION_MESSAGE);
        }
    }
}
