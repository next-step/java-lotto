package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해주세요");
        int purchaseAmount = Integer.parseInt(scanner.nextLine());

        return purchaseAmount;
    }

    public static List<String> inputManualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoCount = Integer.parseInt(scanner.nextLine());

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> inputManualLottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            String inputManualLotto = scanner.nextLine();
            inputManualLottos.add(inputManualLotto);
        }

        return inputManualLottos;
    }

    public static String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputNumbers = scanner.nextLine();

        return inputNumbers;
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String inputBonusNumber = scanner.next();

        return inputBonusNumber;
    }
}
