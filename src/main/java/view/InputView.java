package view;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final String INPUT_BUY_PRICE_MESSAGE = "구입 금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final String INPUT_MANUAL_BUY_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String INPUT_BUY_MANUAL_LOTTO_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputBuyPrice() {
        System.out.println(INPUT_BUY_PRICE_MESSAGE);
        return scanner.nextInt();
    }

    public static String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        return scanner.next();
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return scanner.nextInt();
    }

    public static int inputManualCount() {
        System.out.println(INPUT_MANUAL_BUY_COUNT_MESSAGE);
        return scanner.nextInt();
    }

    public static List<String> inputPassivityCountLottos(int manualCount) {
        System.out.println(INPUT_BUY_MANUAL_LOTTO_MESSAGE);

        return IntStream.range(0, manualCount)
                .mapToObj(it -> scanner.next())
                .collect(Collectors.toList());
    }
}
