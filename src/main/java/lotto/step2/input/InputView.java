package lotto.step2.input;

import lotto.step2.domain.WinnerNumbers;
import lotto.step2.service.LottoProgram;

import java.util.Scanner;

public class InputView {
    private InputView() {
        throw new IllegalStateException("Utility class");
    }

    public static UserInput inputPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");

        int purchaseAmount = scanner.nextInt();

        while (purchaseAmount < LottoProgram.LOTTO_PRICE) {
            System.out.println("최소 구입금액은 " + LottoProgram.LOTTO_PRICE + "원 입니다.\n구입금액을 다시 입력해 주세요.");

            purchaseAmount = scanner.nextInt();
        }

        return new UserInput(purchaseAmount);
    }

    public static WinnerNumbers inputWinnersNumbers() {
        Scanner scanner = new Scanner(System.in);

        final String winnerNumbersText = getWinnerNumbersText(scanner);
        final int bonusWinnerNumber = getBonusWinnerNumber(scanner);

        return new WinnerNumbers(winnerNumbersText, bonusWinnerNumber);
    }

    private static String getWinnerNumbersText(final Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    private static int getBonusWinnerNumber(final Scanner scanner) {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
