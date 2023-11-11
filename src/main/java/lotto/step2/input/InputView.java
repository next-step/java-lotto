package lotto.step2.input;

import lotto.step2.domain.WinnerNumbers;

import java.util.Scanner;

public class InputView {
    public static UserInput inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        final int purchaseAmount = scanner.nextInt();

        return new UserInput(purchaseAmount);
    }

    public static WinnerNumbers inputWinnersNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        final String winnerNumbersText = scanner.nextLine();
        
        return new WinnerNumbers(winnerNumbersText);
    }
}
