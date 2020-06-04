package dev.dahye.lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int doInputMoney() {
        System.out.println("구입 금액을 입력하세요.");
        int purchaseAmount = Integer.parseInt(scanner.nextLine());

        return purchaseAmount;
    }

    public static String doInputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String winningNumbers = scanner.nextLine();

        return winningNumbers;
    }
}
