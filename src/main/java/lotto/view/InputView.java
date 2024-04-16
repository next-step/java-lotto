package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int inputPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");

        int purchaseAmount = scanner.nextInt();
        scanner.nextLine();

        return purchaseAmount;
    }

    public String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return scanner.nextLine();
    }

    public String inputBonusWinningNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        return scanner.nextLine();
    }

    public int inputManualPurchaseCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        int manualPurchaseCount = scanner.nextInt();
        scanner.nextLine();

        return manualPurchaseCount;
    }

    public List<String> inputManualLottoNumber(int manualPurchaseCount) {
        List<String> lottoNumbers = new ArrayList<>();

        if (manualPurchaseCount <= 0) {
            return lottoNumbers;
        }

        System.out.println("수동으로 구매할 번호를 입력해주세요.");

        for (int i = 0; i < manualPurchaseCount; i++) {
            lottoNumbers.add(scanner.nextLine());
        }

        return lottoNumbers;
    }
}
