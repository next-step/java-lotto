package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private InputView() {}

    private static final String INPUT_MESSAGE = "구입금액을 입력해주세요.";
    private static final String INPUT_NUMBER_VALIDATION_MESSAGE = "숫자를 입력해주세요.";
    private static final String INPUT_MANUAL_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO = "수동으로 구매할 번호를 입력해 주세요";
    private static final String LAST_WEEK_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_LOTTO = "보너스 볼을 입력해 주세요.";
    private static final String SPLIT_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println(INPUT_MESSAGE);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException(INPUT_NUMBER_VALIDATION_MESSAGE);
        }
    }

    public static int inputManualLottoCount() {
        System.out.println(INPUT_MANUAL_COUNT_MESSAGE);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException(INPUT_NUMBER_VALIDATION_MESSAGE);
        }
    }

    public static List<List<Integer>> inputManualLottoNumbers(int inputManualCounts) {
        System.out.println(INPUT_MANUAL_LOTTO);
        List<List<Integer>> manualNumbersList = new ArrayList<>();
        while (inputManualCounts-- > 0) {
            String[] inputNumbers = scanner.nextLine().split(SPLIT_DELIMITER);
            manualNumbersList.add(parseInteger(inputNumbers));
        }
        return manualNumbersList;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(LAST_WEEK_LOTTO);
        String[] inputNumbers = scanner.nextLine().split(SPLIT_DELIMITER);
        return parseInteger(inputNumbers);
    }

    private static List<Integer> parseInteger(String[] inputNumbers) {
        return Arrays.stream(inputNumbers)
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        System.out.println(BONUS_LOTTO);
        return scanner.nextInt();
    }
}
