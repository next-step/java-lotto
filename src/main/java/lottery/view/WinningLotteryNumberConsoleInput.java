package lottery.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WinningLotteryNumberConsoleInput {

    private static final String WINNING_LOTTERY_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String DELIMITER = ", ";

    private final Scanner scanner = new Scanner(System.in);

    public List<Integer> askWinningLotteryNumbers() {
        System.out.println(WINNING_LOTTERY_QUESTION);
        return Arrays.stream(scanner.nextLine().split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
