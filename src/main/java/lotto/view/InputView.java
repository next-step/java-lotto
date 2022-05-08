package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new IllegalArgumentException();
    }

    public static int getMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static String getWinnerTicket() {
        SCANNER.nextLine();
        System.out.println("지난주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }
}
