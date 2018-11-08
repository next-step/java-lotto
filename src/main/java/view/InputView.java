package view;

import java.util.Scanner;

public class InputView {
    //private  static Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        return amount;
    }

    public static String inputLastWeeksWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String winningNumbers = scanner.nextLine();
        return winningNumbers;
    }
}
