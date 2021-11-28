package lotto.view;

import lotto.model.Lotto;
import lotto.model.Number;
import lotto.utils.ScannerUtils;

public final class InputView {

    private static final String DELIMITER = ",";

    private InputView() {
    }

    public static int acceptPuchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        int purchasedAmount = ScannerUtils.nextInt();
        int purchasedCount = Lotto.getLottoCount(purchasedAmount);
        System.out.println(purchasedCount + "개를 구매했습니다.");
        return purchasedCount;
    }

    public static String[] acceptWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        return ScannerUtils.nextLine().split(DELIMITER);
    }

    public static Number acceptBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
        return new Number(ScannerUtils.nextInt());
    }
}
