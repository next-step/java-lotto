package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static Scanner scanner;

    private static final String BUY_AMOUNT_INPUT_TEXT = "구입금액을 입력해 주세요.";
    private static final String LAST_WEEK_WINNING_NUMBER_INPUT_TEXT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String LAST_WEEK_WINNING_NUMBER_REX_PATTERN = ", ";


    public static int inputBuyAmount() {
        scanner = new Scanner(System.in);
        System.out.println(BUY_AMOUNT_INPUT_TEXT);
        return scanner.nextInt();
    }

    public static List<Integer> inputLastWeekWinningNumber() {
        System.out.println(LAST_WEEK_WINNING_NUMBER_INPUT_TEXT);
        scanner = new Scanner(System.in);
        String lastWeekWinningNumber = scanner.nextLine();
        System.out.println(lastWeekWinningNumber);
        return Arrays.stream(lastWeekWinningNumber.split(LAST_WEEK_WINNING_NUMBER_REX_PATTERN))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
