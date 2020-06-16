package lotto.ui;

import lotto.util.LottoUtil;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static int enterPurchaseAmount() {
        System.out.println("\n구입 금액을 입력해 주세요.");
        int amount = SCANNER.nextInt();
        SCANNER.nextLine();
        return amount;
    }

    public static int enterManualCount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCount = SCANNER.nextInt();
        SCANNER.nextLine();
        return manualCount;
    }

    public static List<String> enterManualNumbers(int quantity, int manualCount) {
        LottoUtil.checkManualCount(quantity, manualCount);
        if(manualCount == 0) {
            return Collections.emptyList();
        }

        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        return Stream.generate(() -> SCANNER.nextLine())
                .limit(manualCount)
                .collect(Collectors.toList());

    }

    public static String enterWinningNumber() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String winningNumber = SCANNER.nextLine();
        return winningNumber;
    }

    public static int enterBonusBall() {
        System.out.println("\n보너스 볼을 입력해 주세요.");
        int bonusBall = SCANNER.nextInt();
        return bonusBall;
    }

}
