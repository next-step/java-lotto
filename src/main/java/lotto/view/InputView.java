package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in);

    private final static String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String INPUT_WINNER_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_NUMBERS_MESSAGE = "보너스 볼을 입력해 주세요.";
    private final static String INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private final static String INPUT_MANUAL_LOTTO_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    private InputView() {
    }

    public static String printInputMessageNGetAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
        return getStringFromUserInput();
    }

    public static String printInputMessageNGetWinnerNumbers() {
        System.out.println(INPUT_WINNER_NUMBERS_MESSAGE);
        return getStringFromUserInput();
    }

    public static String printInputMessageNGetBonusNumbers() {
        System.out.println(INPUT_BONUS_NUMBERS_MESSAGE);
        return getStringFromUserInput();
    }

    public static String printInputManualLottoCountMessageNGetCount() {
        System.out.println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE);
        return getStringFromUserInput();
    }

    public static List<String> printInputManualLottoesMessageNGetUserInput(int count) {
        System.out.println(INPUT_MANUAL_LOTTO_MESSAGE);

        return IntStream.range(0, count)
                .mapToObj(idx -> SCANNER.nextLine())
                .collect(Collectors.toList());
    }

    public static String getStringFromUserInput() {
        return SCANNER.nextLine();
    }

}
