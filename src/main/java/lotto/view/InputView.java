package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    public static final String INPUT_MANUAL_LOTTO_QUANTITY = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String INPUT_MANUAL_LOTTO_NUMBERS = "\n수동으로 구매할 번호를 입력해 주세요.";

    private InputView() {
    }

    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final String INPUT_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    public static String inputMoney() {
        return inputWithText(INPUT_PURCHASE_MESSAGE);
    }

    public static String inputManualQuantity() {
        return inputWithText(INPUT_MANUAL_LOTTO_QUANTITY);
    }

    public static List<String> inputLottoNumber(int tryCount) {
        System.out.println(INPUT_MANUAL_LOTTO_NUMBERS);
        return IntStream.range(0, tryCount)
                .mapToObj(i -> inputString())
                .collect(Collectors.toList());
    }

    public static String inputWinningNumbers() {
        return inputWithText(INPUT_WINNING_NUMBER_MESSAGE);
    }

    public static String inputBonusNumber() {
        return inputWithText(INPUT_BONUS_NUMBER);
    }


    private static String inputWithText(String text) {
        System.out.println(text);
        return inputString();
    }

    private static String inputString() {
        try {
            return BR.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
