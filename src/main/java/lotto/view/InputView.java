package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String DELIMITER = ",";
    private static final String PURCHASE_TICKET_MANAGER_LOG = "구입금액을 입력해 주세요.";
    private static final String MANUAL_COUNT_MANAGER_LOG = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_MANAGER_LOG = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_NUMBER_MANAGER_LOG = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_MANAGER_LOG = "보너스 볼을 입력해 주세요.";
    private static final String NOT_BLANK_EXCEPTION = "공백은 들어올 수 없습니다.";


    public static int inputBuyCash() {
        try {
            System.out.println(PURCHASE_TICKET_MANAGER_LOG);
            return getInteger();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputBuyCash();
        }
    }

    public static int inputManualCount() {
        try {
            System.out.println(MANUAL_COUNT_MANAGER_LOG);
            return getInteger();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputManualCount();
        }
    }

    public static List<String[]> inputManualLotto(int count) {
        try {
            if (count == 0) return new ArrayList<>();

            System.out.println(MANUAL_LOTTO_MANAGER_LOG);
            List<String[]> result = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                result.add(getNumbers());
            }

            return result;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputManualLotto(count);
        }
    }


    public static String[] inputWinningNumbers() {
        try {
            System.out.println(WINNING_NUMBER_MANAGER_LOG);
            return getNumbers();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputWinningNumbers();
        }
    }

    public static String inputBonusNumber() {
        try {
            System.out.println(BONUS_BALL_MANAGER_LOG);
            String input = scanner.nextLine();
            checkEmpty(input);
            return input;
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

    private static int getInteger() {
        String input = scanner.nextLine();
        checkEmpty(input);
        return Integer.parseInt(input);
    }

    private static String[] getNumbers() {
        String input = scanner.nextLine();
        checkEmpty(input);
        return input.split(DELIMITER);
    }
}
