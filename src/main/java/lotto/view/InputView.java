package lotto.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner;

    public long inputMoney() {
        scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLong();
    }

    public String inputWinningNumber() {
        scanner = new Scanner(System.in);
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}
