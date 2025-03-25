package lotto;

public class LottoSeller {
    public static final int PRICE = 1000;

    public int getPurchasableLottoCount(UserMoneyInput userInput) {
        return userInput.getMoneyAmount() / PRICE;
    }
}
