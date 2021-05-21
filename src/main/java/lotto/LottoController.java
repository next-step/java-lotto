package lotto;

public class LottoController {
    private static PurchaseAmount purchaseAmount;

    public static void main(String[] args) {
        InputView inputView = new InputView();
        purchaseAmount = new PurchaseAmount(inputView.inputPurchaseAmount());
    }
}
