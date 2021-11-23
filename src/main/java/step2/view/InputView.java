package step2.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CASH_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LAST_WEEK_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputCash() {
        System.out.println(INPUT_CASH_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputLastWeekLottoNumber() {
        System.out.println(INPUT_LAST_WEEK_LOTTO_NUMBER_MESSAGE);
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static int inputManualLottoCount() {
        System.out.println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static void inputManualLottoNumberMessage() {
        System.out.println(INPUT_MANUAL_LOTTO_NUMBER_MESSAGE);
    }

    public static String inputManualLottoNumber() {
        return scanner.nextLine();
    }
}
