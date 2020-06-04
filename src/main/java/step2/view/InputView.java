package step2.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_PURCHASE_PRICE_TEXT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_NUMBER_TEXT = "지난 주 당첨 번호를 입력해 주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE_TEXT);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String inputWinningLottoNumber() {
        System.out.println(INPUT_WINNING_LOTTO_NUMBER_TEXT);
        return SCANNER.nextLine();
    }
}
