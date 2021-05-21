package lotto;

public class PurchaseLotto {
    private static final int LOTTO_PRICE = 1000;
    private static InputAmount inputAmount;


    public PurchaseLotto() {
        InputView inputView = new InputView();
        inputAmount = new InputAmount(inputView.inputPurchaseAmount());

    }
}
