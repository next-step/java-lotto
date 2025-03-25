package ui;

import model.lotto.Lotto;

import java.util.Scanner;

public class InputView {

    public static int getPayAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static Lotto getLastWeekWinNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return new Lotto(input);
    }

    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
