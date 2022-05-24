package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String START_MESSAGE = "구매금액을 입력해주세요.";
    private static final String MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    private static final String BONUS_LOTTO_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPurchaseAmount() {
        System.out.println(START_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static int inputManualLottoCount() {
        System.out.println(MANUAL_LOTTO_COUNT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<String> inputManualLottoList(int count) {
        System.out.println(MANUAL_LOTTO_NUMBER);
        List<String> lottos = new ArrayList<>();
        for (int index = 1; index <= count; index++) {
            lottos.add(scanner.nextLine());
        }
        return lottos;
    }

    public static String inputLastWeekWinningNumber() {
        System.out.println(WINNING_LOTTO_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputLastWeekBonusNumber() {
        System.out.println(BONUS_LOTTO_MESSAGE);
        return scanner.nextLine();
    }
}
