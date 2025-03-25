package lotto.view;

import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수형의 숫자를 입력해주세요.");
        }
    }

    public static void printLottoCount(int count) {
        System.out.printf("%d개를 구매했습니다.%n", count);
    }

    public static String inputWinningNumber() {
        System.out.println(System.lineSeparator() + "지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }
}
