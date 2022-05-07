package lotto.view;

import lotto.util.SplitStringUtils;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String COMMA_DELIMITER = ",";
    private static final String PURCHASE_AMOUNT_GUIDE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_GUIDE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_GUIDE = "보너스 볼을 입력해 주세요.";

    private InputView() {
    }

    public static String scanPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_GUIDE);
        return scanner.nextLine();
    }

    public static List<String> scanWinningNumbers() {
        System.out.println(WINNING_NUMBER_GUIDE);
        return SplitStringUtils.split(scanner.nextLine(), COMMA_DELIMITER);
    }

    public static String scanBonusNumber() {
        System.out.println(BONUS_BALL_GUIDE);
        return scanner.nextLine();
    }
}
