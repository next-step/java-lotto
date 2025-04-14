package step2.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static long purchaseAmount() {
        System.out.println("구입금액을 입력해주세요.");
        return scanner.nextLong();
    }

    public static String inputLastWinningLottoNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine(); // flush
        return scanner.nextLine();
    }
}
