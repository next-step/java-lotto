package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String GET_MONEY_FROM_USER_MESSAGE = "구입 금액을 입력해주세요.";
    private static final String GET_MANUAL_LOTTO_COUNT_MESSAGE = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String GET_MANUAL_LOTTO_MESSAGE = "\n수동으로 구매할 로또 번호를 입력해 주세요.";
    private static final String GET_WINNING_LOTTO_FROM_USER_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_LOTTO_FROM_USER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String getMoneyToPurchase() {
        System.out.println(GET_MONEY_FROM_USER_MESSAGE);
        return SCANNER.nextLine();
    }

    public static String getManualLottoCount() {
        System.out.println(GET_MANUAL_LOTTO_COUNT_MESSAGE);
        return SCANNER.nextLine();
    }

    public static List<String> getManualLotto(int lottoCount) {
        System.out.println(GET_MANUAL_LOTTO_MESSAGE);
        List<String> lotto = new ArrayList<>();
        while (lottoCount-- > 0) {
            lotto.add(SCANNER.nextLine());
        }
        return lotto;
    }

    public static String getWinningLotto() {
        System.out.println(GET_WINNING_LOTTO_FROM_USER_MESSAGE);
        return SCANNER.nextLine();
    }

    public static String getBonusBall() {
        System.out.println(GET_BONUS_LOTTO_FROM_USER_MESSAGE);
        return SCANNER.nextLine();
    }
}
