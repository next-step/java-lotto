package view;

import java.util.Scanner;

public class InputView {
    public static int getAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");

        int inputAmount = scanner.nextInt();
        return inputAmount;
    }

    public static String getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String winningNumbers = scanner.nextLine();
        return winningNumbers;
    }
}
