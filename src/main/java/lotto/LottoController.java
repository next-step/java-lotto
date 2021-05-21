package lotto;

public class LottoController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        PurchaseLotto purchaseLotto = new PurchaseLotto(inputView.inputPurchaseAmount());
    }
}
