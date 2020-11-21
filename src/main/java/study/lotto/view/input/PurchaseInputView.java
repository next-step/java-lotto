package study.lotto.view.input;

import study.lotto.PurchaseAmount;
import study.lotto.view.AbstractView;

import java.util.Scanner;

public class PurchaseInputView extends AbstractView {

    private PurchaseInputView() {}

    public static PurchaseAmount display() {
        return new PurchaseAmount(purchaseAmountView(), numberOfManualLottoView());
    }

    private static int purchaseAmountView() {
        stringBuilder.append("구매 금액을 입력해주세요.");
        printAndClear();

        return scanner.nextInt();
    }

    private static int numberOfManualLottoView() {
        stringBuilder.append("수동으로 구매할 로또 수를 입력해 주세요.");
        printAndClear();

        return scanner.nextInt();
    }

    public static void displayPurchaseAmount(PurchaseAmount purchaseAmount) {
        stringBuilder.append("수동으로 ");
        stringBuilder.append(purchaseAmount.getNumberOfManualLotto());
        stringBuilder.append("장, 자동으로 ");
        stringBuilder.append(purchaseAmount.getNumberOfAutoLotto());
        stringBuilder.append("개를 구매했습니다");
        printAndClear();
    }
}
