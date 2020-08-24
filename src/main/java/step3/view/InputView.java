package step3.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int receiveMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = scanner.nextInt();
        return money;
    }

    public static String receiveWinningNumberLine() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        return scanner.nextLine();
    }

}
