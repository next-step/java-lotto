package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String SPACES = "\\s+";
    private static final String EMPTY_STRING = "";
    private static final String EMPTY_INPUT_EXCEPTION_MESSAGE = "입력은 공백일 수 없습니다.";

    private InputView() {}

    public static String inputBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        return input();
    }

    public static String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return removeBlank(input());
    }

    private static String removeBlank(final String inputNumbers) {
        return inputNumbers.replaceAll(SPACES, EMPTY_STRING);
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return input();
    }

    private static void validateBlank(final String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_EXCEPTION_MESSAGE);
        }
    }

    private static String input() {
        final Scanner sc = new Scanner(System.in);
        final String input = sc.nextLine().trim();
        validateBlank(input);

        return input;
    }
}
