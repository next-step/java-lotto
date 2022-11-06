package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_START_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_TICKET_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBERS_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String COMMA_SEPARATOR = ", ";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int getMoney() {
        System.out.println(INPUT_START_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<List<Integer>> getManualLottoNumbers() {
        System.out.println();
        System.out.println(INPUT_MANUAL_TICKET_COUNT);
        int manualTicketCount = Integer.parseInt(scanner.nextLine());
        return getManualLottoNumbers(manualTicketCount);
    }

    private static List<List<Integer>> getManualLottoNumbers(final int manualTicketCount) {
        System.out.println();
        System.out.println(INPUT_MANUAL_NUMBERS);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < manualTicketCount; i++) {
            result.add(Arrays.stream(scanner.nextLine().split(COMMA_SEPARATOR))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        }
        return result;
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        String[] input = scanner.nextLine().split(COMMA_SEPARATOR);
        return Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int getBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBERS_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }
}
