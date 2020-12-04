package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    private InputView() {
    }

    public static int inputMoney() {
        System.out.println("구입금액은 입력해 주세요.");
        return sc.nextInt();
    }

    public static String inputWinningNumber() {
        sc.nextLine();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine();
    }

    public static int inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }
}
