package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputConsoleView {
    private static Scanner scanner = new Scanner(System.in);

    private InputConsoleView() {
    }

    public static int inputPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        return inputInteger();
}

    public static int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return inputInteger();
    }

    public static List<String> inputManualLotto(int manualLottoCount) {
        return inputManualLottoTickets(manualLottoCount);
    }

    public static String inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return inputInteger();
    }

    private static List<String> inputManualLottoTickets(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualLottoTickets = new ArrayList<>();
        for(int i = 0; i < manualLottoCount; i++) {
            manualLottoTickets.add(scanner.nextLine());
        }
        return manualLottoTickets;
    }

    private static int inputInteger() {
        final int manualLottoCount = scanner.nextInt();
        scanner.nextLine();
        return manualLottoCount;
    }
}
