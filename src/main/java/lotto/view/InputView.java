package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_START_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String COMMA_SEPARATOR = ", ";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int getMoney() {
        System.out.println(INPUT_START_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        String[] input = scanner.nextLine().split(COMMA_SEPARATOR);
        List<Integer> result = Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        scanner.close();
        return result;
    }
}
