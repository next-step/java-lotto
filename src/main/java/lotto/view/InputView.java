package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            return scanner.nextInt();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }
    }

    public static String requestWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        scanner.nextLine();
        return scanner.nextLine();
    }
}
