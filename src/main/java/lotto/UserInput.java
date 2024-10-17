package lotto;

import java.util.Scanner;

public class UserInput {

    /**
     * 구입금액을 입력해 주세요.
     * 14000
     */
    public static Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return new Money(scanner.nextInt());
    }

    /**
     * 지난 주 당첨 번호를 입력해 주세요.
     * 1, 2, 3, 4, 5, 6
     */
    public static Winners inputWinners() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return new Winners(str);
    }
}
