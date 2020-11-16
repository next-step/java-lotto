package lotto.dto;

import lotto.validator.InputValidator;

public class BuyLotto {

    private static final int LOTTO_PRICE = 1_000;
    private final int amount;
    private final int count;

    private BuyLotto(int amount, int count) {
        this.amount = amount;
        this.count = count;
    }

    public static BuyLotto of(String amount) {
        InputValidator.validateBuyLotto(amount);

        return new BuyLotto(Integer.parseInt(amount),
                            Integer.parseInt(amount) / LOTTO_PRICE);
    }

    public int getCount() {
        return this.count;
    }
}
