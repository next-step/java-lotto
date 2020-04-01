package lotto.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        final int money = scanner.nextInt();
        scanner.nextLine();
        return money;
    }

    public static String inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        final int bonusNumber = scanner.nextInt();
        scanner.nextLine();
        return bonusNumber;
    }

}
