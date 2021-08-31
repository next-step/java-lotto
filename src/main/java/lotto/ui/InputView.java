package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String SPACE_REGEX = "\\s+";
    private static final String COMMA_REGEX = ",";
    private static final String EMPTY = "";
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int askUserToPay() {
        System.out.println("구입금액을 입력해주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> askUserToEnterWinningNumbersOfLastWeek() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] userInputs = scanner.nextLine().replaceAll(SPACE_REGEX, EMPTY).split(COMMA_REGEX);
        return Arrays.stream(userInputs)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public int askUserBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }
}
