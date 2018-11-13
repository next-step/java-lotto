package lotto.view;

import lotto.domain.WinningLotto;
import java.util.Scanner;

public class InputView {

    public static int getBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static WinningLotto getWinningNumberWithBonus() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String winningLine = scanner.nextLine();

        String[] splitWinningLine = winningLine.split(",");

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusBall = scanner.nextInt();

        return new WinningLotto(splitWinningLine, bonusBall);
    }

}
