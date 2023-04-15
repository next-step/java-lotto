package lotto.ui;

import lotto.model.WinningInfo;

import java.util.Scanner;

public class InputView {

    private InputView() {}

    private static Scanner scanner = new Scanner(System.in);

    public static int receiveInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = scanner.nextInt();
        scanner.nextLine();
        return money;
    }

    public static WinningInfo receiveInputWinningInfo() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String strWinningNumbers = scanner.nextLine();

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();
        return new WinningInfo(strWinningNumbers, bonusNumber);
    }
}
