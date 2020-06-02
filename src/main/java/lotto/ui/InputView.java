package lotto.ui;

import lotto.domain.WinningNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NUMBERS_SPLIT_DELIMITER = ",";

    private InputView() {}

    public static int getPaid() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static List<Set<Integer>> askManualNumbers() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCount = SCANNER.nextInt();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        return IntStream.range(0, manualCount)
                .mapToObj(i -> parseIntSet(SCANNER.next()))
                .collect(Collectors.toList());
    }

    public static WinningNumbers askWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = SCANNER.next();
        return new WinningNumbers(parseIntSet(input));
    }

    private static Set<Integer> parseIntSet(String input) {
        return Arrays.stream(input.split(NUMBERS_SPLIT_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    public static int askBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }
}
