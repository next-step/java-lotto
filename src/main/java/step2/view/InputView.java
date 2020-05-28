package step2.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String USE_AMOUNT_QUESTION = "구입 금액을 입력해 주세요.";
    private static final String LAST_WEEK_WINNING_NUMBER_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";

    private static final String WINNING_NUMBER_DELIMITER = ",";

    private InputView() {
    }

    public static int getUseAmount() {
        System.out.println(USE_AMOUNT_QUESTION);
        return scanner.nextInt();
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println(LAST_WEEK_WINNING_NUMBER_QUESTION);
        return Arrays.stream(scanner.nextLine().split(WINNING_NUMBER_DELIMITER))
                .map(Integer::new)
                .collect(Collectors.toList());
    }
}
