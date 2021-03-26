package lotto;

import java.util.Scanner;

public class InputView {
    private static final String REQUEST_PURCHASE_MESSAGE = "구매금액을 입력해 주세요.";

    private InputView() {

    }

    public static String getLottoPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            return scanner.nextLine();
        }
        throw new IllegalStateException("입력값을 받지 못했습니다.");
    }

}
