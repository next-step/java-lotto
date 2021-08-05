package lotto.view;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputCash() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        try {
            System.out.println("보너스 볼을 입력해 주세요.");
            return scanner.nextInt();
        } finally {
            closeScanner();
        }
    }

    public static void closeScanner() {
        scanner.close();
    }

    public static int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<String> inputManualLottoNumbers(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> inputManualLottoNumbers = new LinkedList<>();
        scanner.nextLine();
        for (int i = 0; i < manualLottoCount; i++) {
            inputManualLottoNumbers.add(scanner.nextLine());
        }
        return inputManualLottoNumbers;
    }
}
