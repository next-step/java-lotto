package step2.view;

import java.util.Scanner;

public class InputView {
    private InputView() {
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static int getPurchaseAmount() {
        System.out.print("구입 금액을 입력해 주세요: ");
        return scanner.nextInt();
    }

    public static String getWinningNumbers() {
        System.out.print("지난 주 당첨 번호를 입력해 주세요: ");
        return new Scanner(System.in).nextLine();
    }
}
