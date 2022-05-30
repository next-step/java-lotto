package dev.solar.lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final String PURCHASING_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_OF_MANUAL_LOTTO_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String LAST_WEEK_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String DELIMITER = ",";

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        final int amount = scanner.nextInt();
        scanner.nextLine();
        return amount;
    }

    private InputView() {
    }

    public static int inputPurchasingAmount() {
        System.out.println(PURCHASING_AMOUNT_MESSAGE);
        final int amount = scanner.nextInt();
        scanner.nextLine();
        return amount;
    }

    public static int inputNumberOfManualLotto() {
        System.out.println(NUMBER_OF_MANUAL_LOTTO_MESSAGE);
        final int amount = scanner.nextInt();
        scanner.nextLine();
        return amount;
    }

    public static List<Set<String>> inputManualLottoNumbers(int count) {
        System.out.println(MANUAL_LOTTO_NUMBERS_MESSAGE);

        List<Set<String>> lottoNumbers = new ArrayList<>();
        for (int index = 1; index <= count; index++) {
            final String lottoTicketString = scanner.nextLine();
            lottoNumbers.add(Set.of(lottoTicketString.replaceAll(" ", "").split(DELIMITER)));
        }
        return lottoNumbers;
    }

    public static Set<Integer> inputWinningNumbers() {
        System.out.println(LAST_WEEK_WINNING_NUMBER_MESSAGE);
        return Arrays.stream(scanner.nextLine().split(DELIMITER))
                     .map(String::trim)
                     .map(Integer::parseInt)
                     .collect(Collectors.toSet());
    }
}
