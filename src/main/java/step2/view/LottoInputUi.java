package step2.view;

import java.util.Scanner;

public class LottoInputUi {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static String inputLastWeekNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.next();
    }

    public static void close() {
        SCANNER.close();
    }

}
