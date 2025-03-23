package lotto.view;

import java.util.Scanner;

public class InputView {

    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return getNumber();
    }

    private static int getNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return getString();
    }

    private static String getString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    public static int getBonusNumbers() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return getNumber();
    }

}
