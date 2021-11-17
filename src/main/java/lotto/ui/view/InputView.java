package lotto.ui.view;

import java.util.Scanner;

public class InputView {

    private static Scanner SCANNER = new Scanner(System.in);

    public static String string;

    public static int getWon() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }
}
