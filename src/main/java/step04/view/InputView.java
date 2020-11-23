package step04.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private InputView() {}
    private static final String  LOTTO_BUY_PAYING_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String  LOTTO_CREATE_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String  PICK_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String  LOTTO_MANUAL_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String  LOTTO_MANUAL_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static int payLotto() {
        System.out.println(LOTTO_BUY_PAYING_MESSAGE);
        return scanner.nextInt();
    }

    public static String createWinningNumber() {
        System.out.println(LOTTO_CREATE_WINNING_NUMBERS_MESSAGE);
        return scanner.nextLine();
    }

    public static int pickBonusBall() {
        System.out.println(PICK_BONUS_BALL_MESSAGE);
        return scanner.nextInt();
    }

    public static int readManualCount() {
        System.out.println(LOTTO_MANUAL_COUNT_MESSAGE);
        return scanner.nextInt();
    }

    public static List<String> readManualLottos(int count) {
        System.out.println(LOTTO_MANUAL_MESSAGE);
        scanner.nextLine();
        List<String> manualLottos = new ArrayList<>();

        for(int i = 0 ; i < count; i++)
            manualLottos.add(scanner.nextLine());

        return manualLottos;
    }

}
