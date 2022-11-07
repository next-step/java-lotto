package lotto.view;

import java.util.Scanner;

public class UserInput {

    private static final Scanner sc = new Scanner(System.in);
    private UserInput() {
    }

    public static String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return sc.nextLine();
    }

    public static String inputWinningLotto() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine();
    }
}
