package lotto.view;

import java.util.Scanner;

public class InputView {

    public static int readAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return readInt();
    }

    public static String readWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return read();
    }

    private static String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int readBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return readInt();
    }

    private static int readInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
