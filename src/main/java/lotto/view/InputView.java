package lotto.view;

import java.util.Scanner;

public class InputView {
    public static Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }


}
