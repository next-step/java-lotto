package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lotto.model.LottoNumber;
import lotto.model.Money;
import lotto.model.WinningLotto;
import lotto.utils.ScannerUtils;

public final class InputView {

    private static final String DELIMITER = ",";

    private InputView() {
    }

    public static Money acceptPuchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        Money purchasedAmount = new Money(ScannerUtils.nextInt());
        return purchasedAmount;
    }

    public static WinningLotto acceptWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String[] winningNumbers = ScannerUtils.nextLine().split(DELIMITER);

        System.out.println("보너스 볼을 입력해주세요.");
        return WinningLotto.from(Arrays.asList(winningNumbers), new LottoNumber(ScannerUtils.nextInt()));
    }

    public static List<List<String>> acceptManualLottos() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCount = ScannerUtils.nextInt();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return acceptEachManualLotto(manualCount);
    }

    private static List<List<String>> acceptEachManualLotto(int manualCount) {
        List<List<String>> manualLottos = new ArrayList();
        for (int i = 0; i < manualCount; i++) {
            String[] lotto = ScannerUtils.nextLine().split(DELIMITER);
            manualLottos.add(Arrays.asList(lotto));
        }
        return manualLottos;
    }
}
