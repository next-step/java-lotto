package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = scanner.nextInt();
        scanner.nextLine();
        return amount;
    }

    public static String inputLastWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String lastWinningLotto = scanner.nextLine();
        System.out.println();
        return lastWinningLotto;
    }
}
