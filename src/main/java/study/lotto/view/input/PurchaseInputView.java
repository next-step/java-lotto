package study.lotto.view.input;

import study.lotto.PurchaseAmount;
import study.lotto.utils.Utils;
import study.lotto.view.AbstractView;

import java.util.Scanner;

public class PurchaseInputView extends AbstractView {

    private static Scanner scanner = Utils.newScanner();
    private static final String PURCHASE_AMOUNT_MESSAGE = "구매 금액을 입력해주세요.";
    private static final String MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String[] PURCHASE_RESULT_MESSAGES = {
            // 수동으로 1장, 자동으로 1개를 구매했습니다.
            "수동으로 "
            , "장, 자동으로 "
            , "개를 구매했습니다"
    };


    private PurchaseInputView() {}

    public static PurchaseAmount display() {
        return new PurchaseAmount(purchaseAmountView(), numberOfManualLottoView());
    }

    private static int purchaseAmountView() {
        stringBuilder.append(PURCHASE_AMOUNT_MESSAGE);
        printAndClear();

        return scanner.nextInt();
    }

    private static int numberOfManualLottoView() {
        stringBuilder.append(MANUAL_LOTTO_COUNT_MESSAGE);
        printAndClear();

        return scanner.nextInt();
    }

    public static void displayPurchaseAmount(PurchaseAmount purchaseAmount) {
        stringBuilder.append(PURCHASE_RESULT_MESSAGES[0]);
        stringBuilder.append(purchaseAmount.getNumberOfManualLotto());
        stringBuilder.append(PURCHASE_RESULT_MESSAGES[1]);
        stringBuilder.append(purchaseAmount.getNumberOfAutoLotto());
        stringBuilder.append(PURCHASE_RESULT_MESSAGES[2]);
        printAndClear();
    }
}
