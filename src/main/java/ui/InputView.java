package ui;

import model.lotto.Lotto;
import model.lotto.WinningLotto;

import java.util.Scanner;

public class InputView {

    public static int getPayAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static WinningLotto getLastWeekWinNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusBall =  scanner.nextInt();
        return new WinningLotto(input, bonusBall);
    }

    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
