package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int enterPurchaseAmount() {
        System.out.println("구입금액을 입력해주세요");
        return enterNumber();
    }

    public static String enterLottoNumber() {
        return enterString();
    }

    public static String enterString() {
        return SCANNER.next();
    }

    private static int enterNumber() {
        return SCANNER.nextInt();
    }
}
