package lotto.view;

import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String QUESTION_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String QUESTION_WINNING_NUMBER_LAST_WEEK_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String LOTTO_NUMBER_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPurchaseAmount() {
        System.out.println(QUESTION_PURCHASE_AMOUNT_MESSAGE);
        return scanner.nextInt();
    }

    public static WinningLotto inputWinningNumberOfLastWeek() {
        System.out.println(QUESTION_WINNING_NUMBER_LAST_WEEK_MESSAGE);
        String input = scanner.next();
        System.out.println();
        return getWinningNumbersOfLastWeek(input);
    }

    private static WinningLotto getWinningNumbersOfLastWeek(String input) {
        List<Integer> numbers = Arrays.stream(input.replaceAll(" ", "").split(LOTTO_NUMBER_DELIMITER))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        return WinningLotto.of(numbers);
    }
}
