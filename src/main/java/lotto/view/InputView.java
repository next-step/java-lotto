package lotto.view;

import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    public static int inputTotalAmount() {
        System.out.println("구매 금액을 입력해주세요");
        return sc.nextInt();
    }

    public static String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요");
        sc.nextLine();
        return sc.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        return sc.nextInt();
    }
}
