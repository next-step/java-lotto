package lotto.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        scanner = new Scanner(System.in);
        int inputMoney = scanner.nextInt();

        return inputMoney;
    }

    public String inputWinningNumber() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        scanner = new Scanner(System.in);
        String inputWinningNumbers = scanner.next();
        return inputWinningNumbers;
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        scanner = new Scanner(System.in);
        int inputWinningNumbers = scanner.nextInt();
        return inputWinningNumbers;
    }
}
