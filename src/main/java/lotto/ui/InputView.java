package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";
    private static final String SPACE = " ";
    private static final String NO_SPACE = "";

    private InputView() {}

    public static int howMuch() {
        return getInteger("구입 금액을 입력해 주세요.");
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String[] tokens = SCANNER.nextLine().split(DELIMITER);
        return parseTokensToIntegers(tokens);
    }

    private static List<Integer> parseTokensToIntegers(String[] tokens) {
        return Arrays.stream(tokens)
                .map(token -> token.replace(SPACE, NO_SPACE))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static int getBonusNumber() {
        return getInteger("보너스 볼을 입력해 주세요.");
    }

    private static int getInteger(String message) {
        System.out.println(message);
        return Integer.parseInt(SCANNER.nextLine());
    }
}
