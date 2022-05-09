package lotto.view;

import lotto.domain.UserAmount;

import java.util.Scanner;

public class InputView {
    public static final String USER_INPUT_LOTTO_DELIMITER = System.getProperty("line.separator");
    private static final Scanner SCANNER = new Scanner(System.in);

    public static UserAmount inputUserAmount() {
        System.out.println(Message.INPUT_USER_AMOUNT);

        try {
            return new UserAmount(SCANNER.nextInt());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputUserAmount();
        }
    }

    public static String inputPreviousWeekWinningNumber() {
        System.out.println(Message.INPUT_PREVIOUS_WEEK_WINNING_NUMBER);

        return SCANNER.nextLine();
    }

    public static String inputBonusBall() {
        System.out.println(Message.INPUT_BONUS_BALL);

        return SCANNER.nextLine();
    }

    public static int inputNumberOfUserGenerateLotto() {
        System.out.println(Message.INPUT_NUMBER_OF_USER_GENERATE_LOTTO);

        return SCANNER.nextInt();
    }

    public static String inputLottoOfUser(int numberOfUserGenereateLotto) {
        System.out.println(Message.INPUT_LOTTOS_OF_USER);
        SCANNER.nextLine();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numberOfUserGenereateLotto; i++) {
            stringBuilder.append(SCANNER.nextLine());
            stringBuilder.append(USER_INPUT_LOTTO_DELIMITER);
        }

        return stringBuilder.toString();
    }

    private enum Message {
        INPUT_USER_AMOUNT("구입금액을 입력해 주세요."),
        INPUT_PREVIOUS_WEEK_WINNING_NUMBER("지난 주 당첨 번호를 입력해 주세요."),
        INPUT_BONUS_BALL("보너스 볼을 입력해 주세요."),
        INPUT_NUMBER_OF_USER_GENERATE_LOTTO("수동으로 구매할 로또 수를 입력해 주세요."),
        INPUT_LOTTOS_OF_USER("수동으로 구매할 번호를 입력해 주세요.");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return message;
        }
    }
}
