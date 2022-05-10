package lottoauto.view;

import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    private InputView() {}

    public static int inputPurchaseAmount() {
        System.out.println("구매금액을 입력해주세요.");
        return sc.nextInt();
    }

    public static String inputWinningNumbers() {
        sc.nextLine();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }
}
