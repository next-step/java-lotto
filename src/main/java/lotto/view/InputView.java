package lotto.view;

import java.util.Scanner;

public class InputView {
    public static int plzEnterMoney() {
        Printer.println("구입금액을 입력해 주세요.");
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String plzEnterLastWeekWinningNumber() {
        Printer.println("지난 주 당첨 번호를 입력해 주세요.");
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    public static int plzEnterBonusNumber() {
        Printer.println("보너스 볼을 입력해 주세요.");
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
