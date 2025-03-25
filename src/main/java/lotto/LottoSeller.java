package lotto;

public class LottoSeller {
    private static final int PRICE = 1000;

    public int getPurchasableLottoCount(UserInput userInput) {
        return userInput.getMoneyAmount() / PRICE;
    }
}
