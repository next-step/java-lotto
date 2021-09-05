package lotto;

import java.util.Scanner;

public class InputView {

    static Scanner scanner = new Scanner(System.in);

    public static int getPurchaseAmount() {
        printPurchaseAmount();
        return inputPurchaseAmount();
    }

    public static String getWinningNumbers() {
        printWinningNumbers();
        return inputWinningNumbers();
    }

    private static void printPurchaseAmount() {
        System.out.println("구입금액을 입력해주세요.");
    }

    private static int inputPurchaseAmount() {
        return scanner.nextInt();
    }

    private static void printWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
    }

    private static String inputWinningNumbers() {
        return scanner.nextLine();
    }
}
