package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static long enterMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자로 입력해 주세요.");
        }
    }
}
