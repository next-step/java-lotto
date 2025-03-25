package lotto;

public class LottoSeller {
    private static final int PRICE = 1000;

    public int getPurchasableLottoCount(UserMoneyInput userInput) {
        return userInput.getMoneyAmount() / PRICE;
    }
}
