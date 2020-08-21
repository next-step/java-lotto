package step2.ui;

import java.util.Scanner;

public class InputView {

    public static final int AMOUNT_OF_UNITS = 1000;

    public static void startMsg() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static int moneyInput() {
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        if (proofOfAmount(money)) {
            throw new IllegalArgumentException("금액이 잘못 되었습니다.");
        }
        return money / AMOUNT_OF_UNITS;
    }

    static boolean proofOfAmount(int money) {
        return money > 1000
                && money % 1000 != 0;
    }

    public static void printTotalGames(int totalGames) {
        System.out.println(totalGames + "개를 구매했습니다.");
    }

    public static void enterThePreviousNumberMsg() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static String getPreviousNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
