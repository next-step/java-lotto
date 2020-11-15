package lotto.view;

import lotto.domain.Numbers;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String GET_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String GET_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String SPLITTER = ",";
    private static final Scanner scanner = new Scanner(System.in);
    private static final PrintStream out = System.out;

    private InputView() {
    }

    public static Numbers getWinningNumbers() {
        out.println(GET_WINNING_NUMBERS_MESSAGE);

        String[] numStrings = scanner.nextLine().split(SPLITTER);
        List<Integer> numbers = Arrays.stream(numStrings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Numbers(numbers);
    }

    public static int getMoney() {
        out.println(GET_MONEY_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }
}
