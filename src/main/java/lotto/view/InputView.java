package lotto.view;

import java.util.Scanner;

public class InputView {

    static private Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputMoney() {
        System.out.println("구입금액을 입력해주세요");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String[] inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine().split(", ");
    }

    public static int inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }
}

