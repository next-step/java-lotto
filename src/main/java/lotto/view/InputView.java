package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final String PURCHASE_TICKET_MANAGER_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MANAGER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_MANAGER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String DELIMITER = ",";
    private static final String INPUT_IS_EMPTY_ERROR_LOG = "공백은 들어올 수 없습니다.";
    private static final String LOTTO_NUMBER_SIZE_ERROR_LOG = "로또는 " + LOTTO_NUMBER_SIZE + "자리여야 합니다.";

    public static String writePurchaseAmount() {
        try {
            System.out.println(PURCHASE_TICKET_MANAGER_MESSAGE);
            String input = scanner.nextLine();
            checkEmptyString(input);
            return input;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return writePurchaseAmount();
        }
    }

    public static String[] writeWinningNumbers() {
        try {
            System.out.println(WINNING_NUMBER_MANAGER_MESSAGE);
            String input = scanner.nextLine();
            checkEmptyString(input);

            String[] numbers = makeStringToArray(input);
            checkSixNumbers(numbers);
            return numbers;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return writeWinningNumbers();
        }
    }

    public static String writeBonusBall() {
        try {
            System.out.println(BONUS_BALL_MANAGER_MESSAGE);
            String input = scanner.nextLine();
            checkEmptyString(input);
            return input;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return writeBonusBall();
        }
    }

    private static String[] makeStringToArray(String input) {
        return input.split(DELIMITER);
    }

    private static void checkEmptyString(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_IS_EMPTY_ERROR_LOG);
        }
    }

    private static void checkSixNumbers(String[] input) {
        if (input.length != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_ERROR_LOG);
        }
    }
}
