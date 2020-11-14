package step2.view;

import java.util.Scanner;

public class InputView {
    public static int plzEnterMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
