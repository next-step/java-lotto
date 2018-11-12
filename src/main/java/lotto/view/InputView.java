package lotto.view;

import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static int getBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static WinningLotto getWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String winningLine = scanner.nextLine();

        WinningLotto winningLotto = new WinningLotto();
        String[] splitWinningLine = winningLine.split(",");

        for (int i = 0; i < splitWinningLine.length; i++) {
            winningLotto.getWinningNumbers().add(Integer.parseInt(splitWinningLine[i].trim()));
        }

        return winningLotto;
    }


    public static int getBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
