package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);
    public static final String SPACE_REGEX = "\\s+";
    public static final String COMMA_REGEX = ",";
    public static final String EMPTY = "";

    public static int askUserToPayForLottoTickets() {
        System.out.println("구입금액을 입력해주세요.");
        return scanner.nextInt();
    }

    public static List<Integer> getWinningNumbersOfLastWeek() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String[] userInputs = scanner.nextLine().replaceAll(SPACE_REGEX, EMPTY).split(COMMA_REGEX);
        return Arrays.stream(userInputs).map(Integer::valueOf).collect(Collectors.toList());
    }
}
