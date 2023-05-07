package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static String inputWinningNumbers() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 볼을 입력해주세요");
        return SCANNER.nextInt();
    }

    public static int inputManualLottoCount() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static List<String> inputManualLottoNumber(int manualLottoCount) {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        SCANNER.nextLine();
        List<String> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            String manualLottoNumber = SCANNER.nextLine();
            manualLottoNumbers.add(manualLottoNumber);
        }
        return manualLottoNumbers;
    }
}
