package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요. ");

        return input();
    }

    public static String inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return input();
    }

    private static String input() {
        String input = SCANNER.nextLine();

        if (input.isBlank()) {
            throw new IllegalArgumentException("빈값이 입력 되었습니다.");
        }

        return input;
    }
}