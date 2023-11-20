package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() { // 인스턴스화 방지
    }

    public static long inputLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLong();
    }

    public static String inputWinningNumbers() {
        scanner.nextLine();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
