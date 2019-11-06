package lotto.view;

import java.util.InputMismatchException;
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
    private static final Pattern NUMERIC = Pattern.compile("^[0-9]+$");

    public static int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);

        final String amount = scanner.nextLine();
        if (!isNumber(amount)) {
            throw new InputMismatchException("숫자만 입력 가능합니다.");
        }

        return Integer.parseInt(amount);
    }

    public static boolean isNumber(String str) {
        return str != null && NUMERIC.matcher(str).matches();
    }
}
