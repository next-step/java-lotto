package lotto.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String BUY_AMOUNT_INPUT_TEXT = "구입금액을 입력해 주세요.";
    private static final String NUMBER_OF_LOTTO_TO_BUY_MANUALLY_INPUT_TEXT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String LOTTO_NUMBERS_TO_BUY_MANUALLY_INPUT_TEXT = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String LAST_WEEK_WINNING_NUMBER_INPUT_TEXT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_NUMBER_INPUT_TEXT = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_NUMBER_REX_PATTERN = ", ";


    public static int inputBuyAmount() {
        System.out.println(BUY_AMOUNT_INPUT_TEXT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static int inputBuyManuallyCount() {
        System.out.println(NUMBER_OF_LOTTO_TO_BUY_MANUALLY_INPUT_TEXT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static void printInputManuallyLottoNumbers() {
        System.out.println(LOTTO_NUMBERS_TO_BUY_MANUALLY_INPUT_TEXT);
    }

    public static String inputManuallyLottoNumbers() {
        return scanner.nextLine();
    }

    public static String inputLastWeekWinningNumber() {
        System.out.println(LAST_WEEK_WINNING_NUMBER_INPUT_TEXT);
        return scanner.nextLine();
    }

    public static int inputBonusBallNumber(List<Integer> lastWeekWinningNumber) {
        System.out.println(BONUS_BALL_NUMBER_INPUT_TEXT);
        return Integer.parseInt(scanner.nextLine());
    }


}
