package lotto.view;

import java.util.Scanner;

public class LottoInputView {

    public static int purchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = createScanner();
        return scanner.nextInt();
    }

    public static int manualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return createScanner().nextInt();
    }

    public static void manualLottoNumberStart() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static String manualLottoNumber() {
        return createScanner().nextLine();
    }

    public static String lastWeekWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = createScanner();
        return scanner.nextLine();
    }

    public static int bonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = createScanner();
        return scanner.nextInt();
    }

    private static Scanner createScanner() {
        return new Scanner(System.in);
    }
}
