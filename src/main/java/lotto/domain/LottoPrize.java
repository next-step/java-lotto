package lotto.domain;

public class LottoPrize {

    private final int amount;
    private final Currency currency;

    public LottoPrize(int amount,
                      Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

}
