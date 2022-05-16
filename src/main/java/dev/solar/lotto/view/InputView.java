package dev.solar.lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import dev.solar.lotto.LottoNumber;

public class InputView {
    private static final String PURCHASING_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LAST_WEEK_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    private static final String DELIMITER = ",";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPurchasingAmount() {
        System.out.println(PURCHASING_AMOUNT_MESSAGE);
        final int amount = scanner.nextInt();
        scanner.nextLine();
        return amount;
    }

    public static Set<LottoNumber> inputWinningNumbers() {
        System.out.println(LAST_WEEK_WINNING_NUMBER_MESSAGE);
        return Arrays.stream(scanner.nextLine().split(DELIMITER))
                     .map(Integer::parseInt)
                     .map(LottoNumber::new)
                     .collect(Collectors.toSet());
    }
}
