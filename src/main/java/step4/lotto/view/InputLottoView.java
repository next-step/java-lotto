package step4.lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputLottoView {

    private static String INPUT_THE_PURCHASE_AMOUNT = "구매금액을 입력해주세요";
    private static String INPUTTHE_LAST_WEEK_WINNING_AMOUNT = "지난주 당첨 결과를 입력해주세요";
    private static String INPUT_THE_BOUNS_NUMBER = "보너스 번호를 입력해주세요";
    private static String INPUT_THE_MANUAL_BUY_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static String INPUT_THE_MANUAL_BUY_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";

    private static Scanner sc = new Scanner(System.in);


    private InputLottoView() {

    }

    public static int inputPrice() {
        System.out.println(INPUT_THE_PURCHASE_AMOUNT);
        return Integer.parseInt(sc.nextLine());
    }

    public static int inputManualLottoBuyCount() {
        System.out.println(INPUT_THE_MANUAL_BUY_COUNT);
        return Integer.parseInt(sc.nextLine());
    }

    public static List<String> InputManualNumber(int lottoManualBuyCount) {
        List<String> returnValue = new ArrayList<>();
        String manualNumber = "";
        System.out.println(INPUT_THE_MANUAL_BUY_NUMBER);

        for (int i = 0; i < lottoManualBuyCount; i++) {
            manualNumber = sc.nextLine();
            returnValue.add(manualNumber);
        }

        return returnValue;
    }

    public static String inputWinningLottoNumbers() {
        System.out.println();
        System.out.println(INPUTTHE_LAST_WEEK_WINNING_AMOUNT);

        return sc.nextLine();
    }

    public static int inputBounsNumber() {
        System.out.println(INPUT_THE_BOUNS_NUMBER);
        return Integer.parseInt(sc.nextLine());
    }
}
