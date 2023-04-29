package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final String WINNING_NUMBER_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);
    public static int getPurchaseAmount() {
        return scanner.nextInt();
    }

    public static List<Integer> getLastWeekWinningNumbers() {
        scanner.next();
        String winningNumbers = scanner.nextLine();
        String[] split = winningNumbers.split(WINNING_NUMBER_DELIMITER);

        return Arrays.stream(split)
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static int getBonusNum() {
        return scanner.nextInt();
    }
}
