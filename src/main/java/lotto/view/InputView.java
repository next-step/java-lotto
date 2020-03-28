package lotto.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static Integer inputPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        final Integer money = scanner.nextInt();
        scanner.nextLine();
        return money;
    }

    public static String inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

}
