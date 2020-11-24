package step4.view;

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

    public static String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.next();
    }

    public static int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static String inputManualLottoNumbers() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static void close() {
        SCANNER.close();
    }

}
