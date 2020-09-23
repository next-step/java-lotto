package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final String QUESTION_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String QUESTION_MANUAL_LOTTO_COUNT_MESSAGE = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String QUESTION_MANUAL_LOTTO_NUMBER_MESSAGE = "\n수동으로 구매할 번호를 입력해 주세요.";
    private static final String QUESTION_WINNING_NUMBER_LAST_WEEK_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String QUESTION_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPurchaseAmount() {
        System.out.println(QUESTION_PURCHASE_AMOUNT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> inputWinningNumberOfLastWeek() {
        System.out.println(QUESTION_WINNING_NUMBER_LAST_WEEK_MESSAGE);
        String input = scanner.nextLine();
        System.out.println();
        return getWinningNumbersOfLastWeek(input);
    }

    public static List<String> inputManualLotto() {
        System.out.println(QUESTION_MANUAL_LOTTO_COUNT_MESSAGE);
        int manualCount = Integer.parseInt(scanner.nextLine());
        return inputManualLottoNumbers(manualCount);
    }

    private static List<Integer> getWinningNumbersOfLastWeek(String input) {
        return Arrays.stream(input.replaceAll(" ", "").split(DELIMITER))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        System.out.println(QUESTION_BONUS_NUMBER_MESSAGE);
        return scanner.nextInt();
    }

    public static List<String> inputManualLottoNumbers(int manualCount) {
        System.out.println(QUESTION_MANUAL_LOTTO_NUMBER_MESSAGE);
        return IntStream.range(0, manualCount)
                .mapToObj(s -> scanner.nextLine())
                .collect(Collectors.toList());
    }
}
