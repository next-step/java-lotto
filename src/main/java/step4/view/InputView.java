package step4.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private InputView() {

    }

    private static final String PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String MANUAL_BUY_COUNT = "수동으로 구매할 로또 수 입력해 주세요.";
    private static final String MANUAL_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WIN_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    static Scanner sc = new Scanner(System.in);

    public static int inputPurchasePrice() {
        System.out.println(PURCHASE_PRICE);
        return sc.nextInt();
    }

    public static int inputManualBuyCount() {
        System.out.println(MANUAL_BUY_COUNT);
        return sc.nextInt();
    }

    public static List<String> inputManualNumbersList(int manualBuyCount) {
        System.out.println(MANUAL_NUMBER);

        List<String> manualNumbersList = new ArrayList<>();

        sc.nextLine();

        for (int i = 0; i < manualBuyCount; i++) {
            manualNumbersList.add(sc.nextLine());
        }

        return manualNumbersList;
    }

    public static String inputWinNumber() {
        System.out.println();
        System.out.println(WIN_NUMBER);

        sc.nextLine();
        return sc.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println(BONUS_NUMBER);
        return sc.nextInt();
    }
}
