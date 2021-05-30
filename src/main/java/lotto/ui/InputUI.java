package lotto.ui;

import lotto.domains.LottoCount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputUI {
    static Scanner scanner = new Scanner(System.in);

    public static int inputPurchasingAmount() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputWinningNumbers() {
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static int inputManualLottoAmount() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<String> inputManualLottosNumbers(LottoCount manualLottoCount) {
        List<String> returnStringList = new ArrayList<>();
        for (int i = 0; i < manualLottoCount.count(); i++) {
            returnStringList.add(scanner.nextLine());
        }
        return returnStringList;
    }
}
