package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return scanner.nextInt();
    }

    public static List<String> inputManualLotto() {
        System.out.println(INPUT_MANUAL_COUNT_MESSAGE);
        int manualCount = scanner.nextInt();

        System.out.println(INPUT_MANUAL_NUMBER_MESSAGE);
        return Stream.generate(scanner::next)
                .limit(manualCount)
                .collect(toList());
    }

    public static String inputWinningLotto() {
        System.out.println(INPUT_WINNING_LOTTO_MESSAGE);
        return scanner.next();
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return scanner.nextInt();
    }
}
