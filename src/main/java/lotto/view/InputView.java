package lotto.view;

import java.util.Objects;
import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int input = scanner.nextInt();
        validateInputMoney(input);
        scanner.nextLine();

        return input;
    }

    private static void validateInputMoney(final int input) {
        if (input == 0) {
            throw new IllegalArgumentException("입력 값이 누락되었습니다.");
        }
    }

    public static String inputWinningLotto() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        validateInputLotto(input);

        return input;
    }

    private static void validateInputLotto(final String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 누락되었습니다.");
        }
    }
}
