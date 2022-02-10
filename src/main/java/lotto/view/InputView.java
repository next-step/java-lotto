package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String DELIMITER = ",";
    private static final String PURCHASE_TICKET_MANAGER_LOG = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MANAGER_LOG = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_MANAGER_LOG = "보너스 볼을 입력해 주세요.";
    private static final String NOT_BLANK_EXCEPTION = "공백은 들어올 수 없습니다.";


    public static int inputBuyCash() {
        try {
            System.out.println(PURCHASE_TICKET_MANAGER_LOG);
            String input = scanner.nextLine();
            checkEmpty(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputBuyCash();
        }
    }

    public static String[] inputWinningNumbers() {
        try {
            System.out.println(WINNING_NUMBER_MANAGER_LOG);
            String input = scanner.nextLine();
            checkEmpty(input);
            return input.split(DELIMITER);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputWinningNumbers();
        }
    }

    public static int inputBonusNumber() {
        try {
            System.out.println(BONUS_BALL_MANAGER_LOG);
            String input = scanner.nextLine();
            checkEmpty(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputBonusNumber();
        }
    }

    private static void checkEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(NOT_BLANK_EXCEPTION);
        }
    }
}
