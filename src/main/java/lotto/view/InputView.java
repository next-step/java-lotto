package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_BUY_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_MANUAL_TICKETS = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

    private InputView() {
    }

    public static int getInputBuyMoney() {
        System.out.println(INPUT_BUY_MONEY);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getInputWinNumbers() {
        System.out.println(INPUT_WIN_NUMBERS);
        return scanner.nextLine();
    }

    public static String getInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return scanner.next();
    }

    public static int getManualTicket() {
        System.out.println(INPUT_MANUAL_TICKETS);
        return Integer.parseInt(scanner.nextLine());
    }

    public static void printManualNumbers() {
        System.out.println(INPUT_MANUAL_NUMBERS);
    }

    public static String getNextLine() {
        return scanner.nextLine();
    }
}
