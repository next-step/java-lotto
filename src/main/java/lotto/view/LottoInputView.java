package lotto.view;

import java.util.Scanner;

public class LottoInputView {

    public static int purchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = createScanner();
        return scanner.nextInt();
    }

    public static String lastWeekWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = createScanner();
        return scanner.nextLine();
    }

    private static Scanner createScanner() {
        return new Scanner(System.in);
    }
}
