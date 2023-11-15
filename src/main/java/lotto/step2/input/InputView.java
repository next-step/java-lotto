package lotto.step2.input;

import lotto.step2.domain.WinnerNumbers;
import lotto.step2.service.LottoProgram;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private InputView() {
        throw new IllegalStateException("Utility class");
    }

    public static UserInput input() {
        final PurchaseAmount purchaseAmount = inputPurchaseAmount();
        final PassiveLottoCount passiveLottoCount = inputPassiveLottoCount(purchaseAmount.getMaxPassiveLottoCount());

        return new UserInput(purchaseAmount, passiveLottoCount);
    }

    private static PurchaseAmount inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        PurchaseAmount purchaseAmount = null;

        while (purchaseAmount == null) {
            purchaseAmount = inputPurchaseAmountByScanner();
        }

        return purchaseAmount;
    }

    private static PurchaseAmount inputPurchaseAmountByScanner() {
        try {
            final int purchaseAmount = new Scanner(System.in).nextInt();

            return new PurchaseAmount(purchaseAmount);
        } catch (InputMismatchException | IllegalArgumentException e) {
            printPurchaseAmountException();

            return null;
        }
    }

    private static void printPurchaseAmountException() {
        System.out.printf(
                "구입 금액을 숫자로만 다시 입력해 주세요.%n(범위 : %d ~ %d)%n"
                , LottoProgram.LOTTO_PRICE, PurchaseAmount.MAX_VALUE);
    }

    private static PassiveLottoCount inputPassiveLottoCount(final int maxPassiveLottoCount) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        PassiveLottoCount passiveLottoCount = null;

        while (passiveLottoCount == null) {
            passiveLottoCount = inputPassiveLottoCountByScanner(maxPassiveLottoCount);
        }

        return passiveLottoCount;
    }

    private static PassiveLottoCount inputPassiveLottoCountByScanner(final int maxPassiveLottoCount) {
        try {
            final int passiveLottoCount = new Scanner(System.in).nextInt();

            return new PassiveLottoCount(passiveLottoCount, maxPassiveLottoCount);
        } catch (InputMismatchException | IllegalArgumentException e) {
            printPassiveLottoCountException(maxPassiveLottoCount);

            return null;
        }
    }

    private static void printPassiveLottoCountException(final int maxPassiveLottoCount) {
        System.out.printf(
                "수동으로 구매할 로또 수를 숫자로만 다시 입력해 주세요.%n(범위 : 1 ~ %d)%n"
                , maxPassiveLottoCount);
    }

    public static WinnerNumbers inputWinnersNumbers() {
        final String winnerNumbersText = getWinnerNumbersText();
        final int bonusWinnerNumber = getBonusWinnerNumber();

        return new WinnerNumbers(winnerNumbersText, bonusWinnerNumber);
    }

    private static String getWinnerNumbersText() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Scanner(System.in).nextLine();
    }

    private static int getBonusWinnerNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }
}
