package lotto.view;

import java.util.Scanner;

public class InputView {

        public static long scanPurchaseAmount() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("구입금액을 입력해 주세요.");
                return scanner.nextLong();
        }

        public static String scanWinningNumberText() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("지난 주 당첨 번호를 입력해 주세요.");
                return scanner.nextLine();
        }
}
