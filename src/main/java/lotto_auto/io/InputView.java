package lotto_auto.io;

import java.util.Scanner;

public class InputView {
    public static int budget;
    public static int initialBudget;
    public String winningNumber;

    public InputView() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        budget = scanner.nextInt();
        initialBudget = budget;
    }

    public void getWinningNumberComment() {
        System.out.println("\n지난 주 당첨 번호를 입력 해주세요.");
        Scanner scanner = new Scanner(System.in);
        winningNumber = scanner.nextLine();
    }
}
