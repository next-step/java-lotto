package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String BUY_LOTTO_COUNT_INPUT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String PASSIVITY_BUY_INPUT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String LASTWEEK_WIN_NUMBER_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String PASSIVITY_BUY_LOTTO_NUMBER_INPUT_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    public static String receiveBuyAmount() {
        System.out.println(BUY_LOTTO_COUNT_INPUT_MESSAGE);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static String receiveBuyPassivityCount() {
        System.out.println(PASSIVITY_BUY_INPUT_MESSAGE);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static List<String> receiveBuyPassivityLottoNumber(final int count) {
        if (count <= 0) {
            return new ArrayList<>();
        }

        System.out.println(PASSIVITY_BUY_LOTTO_NUMBER_INPUT_MESSAGE);
        Scanner sc = new Scanner(System.in);
        List<String> input = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            input.add(sc.nextLine());
        }

        return input;
    }

    public static String receiveWinNumber() {
        System.out.println(LASTWEEK_WIN_NUMBER_INPUT_MESSAGE);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static String receiveBonusWinNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
