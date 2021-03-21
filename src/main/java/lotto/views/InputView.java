package lotto.views;

import lotto.utils.StringUtils;

import java.util.Scanner;

public class InputView {
    public final static String AMOUNT = "구입금액을 입력해 주세요.";
    public final static String WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    public final static String BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    public final static String MANUAL_BUY_QUANTITY = "수동으로 구매할 로또 수를 입력해 주세요.";
    public final static String MANUAL_BUY_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

    private InputView() { }

    private static void emptyValidation(String value) {
        if (StringUtils.isEmpty(value))
            throw new IllegalArgumentException("유효하지 않은 입력값 입니다.");
    }

    private static String value(String description) {
        System.out.println(description);
        String value = new Scanner(System.in).nextLine();
        emptyValidation(value);
        return value;
    }

    public static String amount() {
        return value(AMOUNT);
    }

    public static String winningNumbers() {
        return value(WINNING_NUMBERS);
    }

    public static String bonusNumber() {
        return value(BONUS_NUMBER);
    }

    public static String manualBuyQuantity() {
        return value(MANUAL_BUY_QUANTITY);
    }

    public static String manualBuyNumbers() {
        return value(MANUAL_BUY_NUMBERS);
    }
}
