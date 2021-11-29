package lotto.view;

import java.util.ArrayList;
import java.util.List;
import lotto.util.ScannerUtils;

public class PaymentView {

    private PaymentView() {
    }

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return ScannerUtils.nextInt();
    }

    public static int inputManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return ScannerUtils.nextInt();
    }

    public static List<String> inputManualLottoNumbers(int manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            lottoNumbers.add(ScannerUtils.nextLine());
        }
        return lottoNumbers;
    }

}
