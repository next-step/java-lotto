package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getPurchaseAmount() {
        OutputView.printPurchaseAmount();
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getWinningNumbers() {
        OutputView.printWinningNumbers();
        return scanner.nextLine();
    }


    public static String getBonusNumber() {
        OutputView.printInputBonusNumber();
        return scanner.nextLine();
    }

    public static int getManualLottoCount() {
        OutputView.printManualLottoCount();
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getManualLottoNumbers() {
        return scanner.nextLine();
    }

}
