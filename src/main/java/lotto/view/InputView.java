package lotto.view;

import lotto.model.Money;
import lotto.model.Number;
import lotto.model.WinningNumber;
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

    public static WinningNumber acceptWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String[] winningNumber = ScannerUtils.nextLine().split(DELIMITER);
        System.out.println("보너스 볼을 입력해주세요.");
        return WinningNumber.from(winningNumber, new Number(ScannerUtils.nextInt()));
    }
}
