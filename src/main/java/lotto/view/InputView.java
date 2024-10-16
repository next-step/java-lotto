package lotto.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private static final String REQUEST_BUY_MONEY_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String REQUEST_WINNER_NUMBER = "지난주 당첨번호를 입력해 주세요.(ex: 1, 2, 3, 4, 5, 6)";
    private static final String REQUEST_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private static final String DEFAULT_SPLIT_DELIMITER = ",";
    private static final String SPACING_REGEX = " ";


    private InputView() {

    }

    public static int requestBuyMoney() {
        System.out.println(REQUEST_BUY_MONEY_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String[] requestWinnerNumber() {
        System.out.println(REQUEST_WINNER_NUMBER);
        return split(replaceSpacing(scanner.nextLine()));
    }

    public static int requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        return Integer.parseInt(scanner.nextLine());
    }

    private static String replaceSpacing(String text) {
        return text.replaceAll(SPACING_REGEX, "");
    }

    private static String[] split(String text) {
        return text.split(DEFAULT_SPLIT_DELIMITER);
    }


}
