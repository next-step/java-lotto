package lotto.view;

import lotto.util.InputUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT_MENT = "구입금액을 입력해 주세요.";
    private static final String PREVIOUS_WINNING_LOTTO_INPUT_MENT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_INPUT_MENT = "보너스 볼을 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBER_INPUT_MENT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_INPUT_MENT = "수동으로 구매할 번호를 입력해 주세요.";

    public static int inputPurchaseAmount(Scanner scanner) {
        try {
            System.out.println(PURCHASE_AMOUNT_INPUT_MENT);
            return scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException(InputUtil.FORMAT_ERROR_MENT);
        }
    }

    public static int inputNumberOfManualLotto(Scanner scanner) {
        try {
            System.out.println(MANUAL_LOTTO_NUMBER_INPUT_MENT);
            return scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException(InputUtil.FORMAT_ERROR_MENT);
        }
    }

    public static List<String> inputManualLotto(Scanner scanner, int number) {
        try {
            System.out.println(MANUAL_LOTTO_INPUT_MENT);
            scanner.nextLine();
            List<String> temp = new ArrayList<>(number);
            while (number-- > 0) {
                temp.add(scanner.nextLine());
            }
            return temp;
        } catch (Exception e) {
            throw new RuntimeException(InputUtil.FORMAT_ERROR_MENT);
        }
    }

    public static String inputPreviousWinningLotto(Scanner scanner) {
        try {
            System.out.println(PREVIOUS_WINNING_LOTTO_INPUT_MENT);
            return scanner.nextLine();
        } catch (Exception e) {
            throw new RuntimeException(InputUtil.FORMAT_ERROR_MENT);
        }
    }

    public static int inputBonusBall(Scanner scanner) {
        try {
            System.out.println(BONUS_BALL_INPUT_MENT);
            return scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException(InputUtil.FORMAT_ERROR_MENT);
        }
    }
}

