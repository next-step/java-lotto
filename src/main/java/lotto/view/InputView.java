package lotto.view;

import lotto.utils.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static final String INPUT_PRICE_MESSAGE = "구입 금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMbERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final String INPUT_MANUAL_PURCHASE_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String INPUT_MANUAL_PURCHASE_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public int inputPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);
        return StringUtils.parseInteger(getMessage());
    }

    public int inputManualPurchaseCount() {
        System.out.println(INPUT_MANUAL_PURCHASE_COUNT_MESSAGE);
        return StringUtils.parseInteger(getMessage());
    }

    public List<String> inputMaunualPurchaseNumbers() {
        System.out.println(INPUT_MANUAL_PURCHASE_NUMBERS_MESSAGE);
        return BR.lines().collect(Collectors.toList());
    }

    public String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMbERS_MESSAGE);
        return getMessage();
    }

    public String inputBonusNumber() {
        System.out.println(INPUT_BONUS_BALL_MESSAGE);
        return getMessage();
    }

    private String getMessage() {
        try {
            return BR.readLine();
        } catch (IOException e) {
            return "";
        }
    }
}
