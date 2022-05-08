package study.step2.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LAST_WEEK_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int getLottoPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getLottoWinningNumber() {
        System.out.println(INPUT_LAST_WEEK_NUMBER_MESSAGE);
        return scanner.nextLine();
    }
}
