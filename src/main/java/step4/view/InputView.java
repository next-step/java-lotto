package step4.view;

import java.util.Scanner;

public class InputView {

    public static final String PURCHASE_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String PURCHASE_LOTTO = "구입금액을 입력해 주세요.";
    private static final String LAST_WEEK_LOTTO = "지난 주 당첨번호를 입력해 주세요.";
    private static final String BONUS_BALL = "보너스 볼을 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);
    public static final String PURCHASE_MANUAL_LOTTO = "수동으로 구매할 번호를 입력해 주세요.";

    private InputView() { }

    public static int purchaseLotto() {
        System.out.println(PURCHASE_LOTTO);
        return scanner.nextInt();
    }
    public static int purchaseManualCount(){
        System.out.println(PURCHASE_MANUAL_LOTTO_COUNT);
        return scanner.nextInt();
    }
    public static String purchaseManualLott(){
        System.out.println(PURCHASE_MANUAL_LOTTO);
        return scanner.next();
    }

    public static String lastWeekLotto() {
        System.out.println(LAST_WEEK_LOTTO);
        return scanner.next();
    }

    public static int initBonusBall() {
        System.out.println(BONUS_BALL);
        return scanner.nextInt();
    }

}
