package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final String INPUT_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public static String inputPurchaseAmount() {
        return inputWithText(INPUT_PURCHASE_MESSAGE);
    }

    public static String inputWinningNumber() {
        return inputWithText(INPUT_WINNING_NUMBER_MESSAGE);
    }

    private static String inputWithText(String text) {
        try {
            System.out.println(text);
            return BR.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
