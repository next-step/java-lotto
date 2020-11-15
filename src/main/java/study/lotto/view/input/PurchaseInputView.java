package study.lotto.view.input;

import study.lotto.PurchaseAmount;
import study.lotto.view.AbstractView;

import java.util.Scanner;

public class PurchaseInputView extends AbstractView {

    private static final PurchaseInputView instance = new PurchaseInputView();

    public static PurchaseInputView getInstance() {
        return instance;
    }

    public PurchaseAmount display() {

        stringBuilder.append("구매 금액을 입력해주세요.");
        printAndClear();

        int amount = scanner.nextInt();

        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);

        stringBuilder.append(purchaseAmount.numberOfPurchases());
        stringBuilder.append("개를 구매했습니다.");

        printAndClear();

        return purchaseAmount;
    }

}
