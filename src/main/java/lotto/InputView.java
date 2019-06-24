package lotto;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputWinningNumber() {
        System.out.println("당첨번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
