package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);
    private static final String WINNING_NUMBER_DELIMITER = ",";

    private InputView() {
    }

    public static Integer askTotalPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.valueOf(SCANNER.nextLine());
    }

    public static List<Integer> askLastWeekWinningNumbers() {
        System.out.println("지난주 당첨번호를 입력해주세요.");
        String winningNumbers = SCANNER.nextLine();
        return Arrays.stream(winningNumbers.split(WINNING_NUMBER_DELIMITER))
                .map(String::trim)
                .map(Integer::new)
                .collect(Collectors.toList());
    }

}
