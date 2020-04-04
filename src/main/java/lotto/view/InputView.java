package lotto.view;

import lotto.domain.ManualLottoOrderSheet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public int inputPurchaseManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public ManualLottoOrderSheet inputManualLottoNumbers(int purchaseManualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < purchaseManualCount; i++) {
            manualLottoNumbers.add(scanner.next());
        }
        return new ManualLottoOrderSheet(manualLottoNumbers);
    }

    public String inputWinningNumber() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return scanner.next();
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
