package lotto.view;

import lotto.domain.Validator;

import java.util.Scanner;

public class InputView {

    private static final String GET_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String GET_LAST_WEEK_WINNING_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_BALL_MESSAGE = "보너스 볼을 입력해주세요.";
    private static final String GET_COUNT_OF_MANUAL_LOTTO = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String GET_NUMBER_OF_MANUAL_LOTTO = "수동으로 구매할 번호를 입력해 주세요.";

    private static Scanner scanner = new Scanner(System.in);

    public static int getMoneyToBuyLotto() {
        System.out.println(GET_MONEY_MESSAGE);
        String input = scanner.nextLine();

        return Validator.checkIsIntegerAndIsNegative(input);
    }

    public static String getLottoAnswer() {
        System.out.println(GET_LAST_WEEK_WINNING_MESSAGE);
        String winningLottoNumber = scanner.nextLine();
        return winningLottoNumber;
    }
    public static int getBonusBall() {
        System.out.println(GET_BONUS_BALL_MESSAGE);
        int bonusBall = scanner.nextInt();
        return bonusBall;
    }

    public static int getNumberOfManualLotto() {
        System.out.println(GET_COUNT_OF_MANUAL_LOTTO);
        String input = scanner.nextLine();
        return Validator.checkIsIntegerAndIsNegative(input);
    }
    public static String getStringOfLotto() {
        return scanner.nextLine();
    }

    public static void printNumberOfManualLotto () {
        System.out.println(GET_NUMBER_OF_MANUAL_LOTTO);
    }
}
