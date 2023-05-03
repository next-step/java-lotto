package step3.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        // 생성자 내부 호출 -> 명시적 Exception
        throw new AssertionError();
    }

    public static int askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static void newLineRemove() {
        SCANNER.nextLine();
    }

    public static String askLastWeekWinningNumbers() {
        System.out.println("지난주 당첨 번호를 입력해주세요.");
        return SCANNER.nextLine();
    }

    public static int askBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();

    }
}
