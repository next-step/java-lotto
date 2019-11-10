package lotto.view;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-07 00:25
 */
public class LottoInputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해주세요.";
    private static final String BLANK = " ";
    private static final String EMPTY = "";
    private static final Pattern NUMERIC = Pattern.compile("^[0-9]+$");

    public static final int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);

        final String amount = scanner.nextLine();

        if (!isNumeric(amount)) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }

        return Integer.parseInt(amount);
    }

    private static boolean isNumeric(String amount) {
        return NUMERIC.matcher(amount).matches();
    }


    public static final String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        return scanner.nextLine().replaceAll(BLANK, EMPTY);
    }
}
