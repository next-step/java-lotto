package lotto;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    public static int getPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    public static String getLastWeekWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine();
    }
}
