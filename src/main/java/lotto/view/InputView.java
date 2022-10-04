package lotto.view;

import lotto.dto.WinningNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final String INPUT_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    public static WinningNumber inputWinningNumbers() {
        return new WinningNumber(inputWinningNumber(), Integer.parseInt(inputBonusNumber()));
    }

    private static String inputWinningNumber() {
        return inputWithText(INPUT_WINNING_NUMBER_MESSAGE);
    }

    private static String inputBonusNumber() {
        return inputWithText(INPUT_BONUS_NUMBER);
    }

    public static String inputPurchaseAmount() {
        return inputWithText(INPUT_PURCHASE_MESSAGE);
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
