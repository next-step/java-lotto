package lotto.view;

import java.util.Scanner;

public class InputView {
    public static int printRequirePrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String printRequireWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
