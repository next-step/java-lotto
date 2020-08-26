package lotto.view;

import lotto.domain.LottoCount;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static lotto.util.ParseUtil.parseToInt;
import static lotto.util.ParseUtil.parseToIntegers;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MULTI_DATA_DELIMITER = ",";
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    private InputView() {}

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return parseToInt(scanner.nextLine());
    }

    public static int inputManualCount() {
        System.out.println(INPUT_MANUAL_COUNT_MESSAGE);
        return parseToInt(scanner.nextLine());
    }

    public static List<List<Integer>> inputManualNumber(LottoCount manualCount) {
        System.out.println(INPUT_MANUAL_NUMBER_MESSAGE);
        return IntStream.range(0, manualCount.getCount())
                .mapToObj(input -> parseToIntegers(scanner.nextLine(), INPUT_MULTI_DATA_DELIMITER))
                .collect(toList());
    }

    public static List<Integer> inputWinningLotto() {
        System.out.println(INPUT_WINNING_LOTTO_MESSAGE);
        return parseToIntegers(scanner.nextLine(), INPUT_MULTI_DATA_DELIMITER);
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return parseToInt(scanner.nextLine());
    }
}
