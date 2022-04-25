package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner INPUT = new Scanner(System.in);

    public static int inputHowMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return INPUT.nextInt();
    }

    public static String inputWinningNumbers() {
        System.out.println("지난 주 당첨 금액을 입력 해 주세요.");
        return INPUT.nextLine();
    }

}
