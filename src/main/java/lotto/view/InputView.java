package lotto.view;

import java.util.Scanner;

public final class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new IllegalCallerException("잘못된 객체생성 입니다.");
    }

    public static int showPaymentConsole() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String showLastWeekWinningNumbersConsole() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

}