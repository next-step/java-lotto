package step2.view;

import java.util.Scanner;

public class InputView {

    private static final String ASK_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ASK_PURCHASE_MANUAL_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String ASK_LAST_PRIZE_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public String price() {
        System.out.println(ASK_PURCHASE_PRICE_MESSAGE);
        return scanner.nextLine();
    }

    public int manual() {
        System.out.println(ASK_PURCHASE_MANUAL_MESSAGE);
        return scanner.nextInt();
    }

    public String prizeLottoNumber() {
        System.out.println(ASK_LAST_PRIZE_NUMBER_MESSAGE);
        return scanner.nextLine();
    }

    public int bonusNumber() {
        System.out.println(ASK_BONUS_NUMBER_MESSAGE);
        return scanner.nextInt();
    }

}
