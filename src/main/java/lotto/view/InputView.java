package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static int plzEnterMoney() {
        Printer.println("구입금액을 입력해 주세요.");
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static int plzEnterManuallyBuyLottoCount() {
        Printer.printNewLine();
        Printer.println("수동으로 구매할 로또 수를 입력해 주세요.");
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<String> plzEnterManuallyBuyLottoNo() {
        final int manuallyBuyLottoCount = plzEnterManuallyBuyLottoCount();
        Printer.printNewLine();
        Printer.println("수동으로 구매할 번호를 입력해 주세요.");
        final Scanner scanner = new Scanner(System.in);
        final List<String> lottoNoList = new ArrayList<>();
        for (int i = 0; i < manuallyBuyLottoCount; i++) {
            lottoNoList.add(scanner.nextLine());
        }
        return lottoNoList;
    }

    public static String plzEnterLastWeekWinningNumber() {
        Printer.println("지난 주 당첨 번호를 입력해 주세요.");
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int plzEnterBonusNumber() {
        Printer.println("보너스 볼을 입력해 주세요.");
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
