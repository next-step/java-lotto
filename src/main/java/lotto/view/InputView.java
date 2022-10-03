package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String PURCHASE_AMOUNT_QUESTION = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String WINNING_NUMBER_DELIMITER = ",";

    public static Integer scanPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_QUESTION);
        Scanner scanner = new Scanner(System.in);

        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> scanWinningNumbers() {
        System.out.println();
        System.out.println(WINNING_NUMBERS_QUESTION);
        Scanner scanner = new Scanner(System.in);

        return Arrays.stream(scanner.nextLine()
                        .split(WINNING_NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
