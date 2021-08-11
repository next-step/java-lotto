package lotto.presentation;

import lotto.presentation.input.PurchaseAmountInputView;
import lotto.presentation.output.ChanceOutputView;

public class LottoController {

    public void execute(){
        int purchaseAmount = inputPurchaseAmount();
        outputPurchaseAmount(purchaseAmount);
    }

    private int inputPurchaseAmount() {
        PurchaseAmountInputView inputView = new PurchaseAmountInputView();
        return inputView.input();
    }

    private void outputPurchaseAmount(int purchaseAmount) {
        ChanceOutputView outputView = new ChanceOutputView();
        outputView.output(purchaseAmount);
    }
}
