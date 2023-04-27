package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toUnmodifiableList;

public final class InputView {

    private static final String NUMBER_DELIMITER = ",";
    private static final String CHAR_WHITE_SPACE = " ";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new IllegalCallerException("잘못된 객체생성 입니다.");
    }

    public static int showPaymentConsole() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static List<Integer> showLastWeekWinningNumbersConsole() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return toNumbers(removeWhiteSpace(SCANNER.nextLine()));
    }

    public static int showBonusBallConsole() {
        System.out.println();
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }

    private static String removeWhiteSpace(String winningNumberAsString) {
        return winningNumberAsString.replace(CHAR_WHITE_SPACE, "");
    }

    private static List<Integer> toNumbers(String refinedWinningNumber) {
        return Arrays.stream(splitDelimiter(refinedWinningNumber))
                .map(Integer::parseInt)
                .collect(toUnmodifiableList());
    }

    private static String[] splitDelimiter(String refinedWinningNumber) {
        return refinedWinningNumber.split(NUMBER_DELIMITER);
    }

}