package step5.view;

import java.util.Scanner;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_OF_MANUAL_LOTTO = "구입금액을 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    private static final Scanner SC = new Scanner(System.in);

    public static Integer requirePurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return SC.nextInt();
    }

    public static Integer requireNumberOfManualLotto() {
        System.out.println(NUMBER_OF_MANUAL_LOTTO);
        return SC.nextInt();
    }

    public static String requireManualLottoNumber() {
        System.out.println(MANUAL_LOTTO_NUMBER);
        return SC.nextLine();
    }
}
