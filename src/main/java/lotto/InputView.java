package lotto;

import java.util.Scanner;

public class InputView {

    static Scanner scanner = new Scanner(System.in);

    public static void refreshLine() {
        inputString();
    }

    public static int getPurchaseAmount() {
        printPurchaseAmount();
        return inputInt();
    }

    public static String getWinningNumbers() {
        printWinningNumbers();
        return inputString();
    }

    public static int getBonusNumber() {
        printBonusNumber();
        return inputInt();
    }

    private static int inputInt() {
        return scanner.nextInt();
    }

    private static String inputString() {
        return scanner.nextLine();
    }

    private static void printPurchaseAmount() {
        System.out.println("구입금액을 입력해주세요.");
    }

    private static void printWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
    }

    public static void printZeroCountError() {
        System.out.println("구매 가능한 로또가 존재하지 않으므로 프로그램을 종료합니다.");
    }

    public static void printInputError() {
        System.out.println("입력값이 올바르지 않습니다.");
    }

    private static void printBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
    }
}
