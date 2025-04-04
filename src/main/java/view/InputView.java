package view;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    public static String showExpressionInput() {
        System.out.println("수식 입력 > ");
        return scanner.nextLine();
    }

    public static Integer showLottoPurchaseAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String showWinningLottoNumbersInput() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static Integer showLottoBonusNumberInput() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static Integer showManualLottoCountInput() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoCount = scanner.nextInt();
        scanner.nextLine();
        return manualLottoCount;
    }

    public static List<Lotto> showManualLottoNumbersInput(int manualLottoCount) {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            String input = scanner.nextLine();
            manualLottoNumbers.add(new Lotto(LottoNumbersParser.parse(input)));
        }
        return manualLottoNumbers;
    }
}
