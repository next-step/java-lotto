package Lotto;

public class LottoProgress {

    private final int LOTTO_PRICE = 1000;

    public int amountToQuantity(Amount amount) {
        return amount.getAmount()/LOTTO_PRICE;
    }
}
