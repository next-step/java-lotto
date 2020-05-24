package lotto.ui;

import java.util.Scanner;

public class InputView {

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요");
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();

        return money;
    }

    public static String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return null;
    }

}
