package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_BUY_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BUY_COUNT = "개를 구매했습니다.";

    private InputView() {
    }

    public static int getInputBuyMoney() {
        System.out.println(INPUT_BUY_MONEY);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String  getInputWinNumbers() {
        System.out.println(INPUT_WIN_NUMBERS);
        return scanner.nextLine();
    }

    public static void printBuyCount(int money) {
        System.out.println(money + INPUT_BUY_COUNT);
    }
}
