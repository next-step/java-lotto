package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.domain.lotto.count.ManualCount;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static String inputManualCount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static List<String> inputManualNumbers(ManualCount manualCount) {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        final List<String> manualNumbers = new ArrayList<>();
        for (int i = 0; i < manualCount.getCountValue(); i++) {
            manualNumbers.add(SCANNER.nextLine());
        }
        return manualNumbers;
    }

    public static String inputLastWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
        return SCANNER.nextLine();
    }
}
