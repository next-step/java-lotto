package lotto.ui;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int buyManualLottoCount() {
        scanner.nextLine();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String manualLottoNumbers(int manualLottoCount) {
        scanner.nextLine();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        StringBuilder manualLottoNumbers = new StringBuilder();
        for(int i = 0; i < manualLottoCount; i++) {
            manualLottoNumbers.append(scanner.nextLine() + "\n");
        }

        return manualLottoNumbers.toString();
    }

    public static String lastWeekWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return scanner.nextInt();
    }
}
