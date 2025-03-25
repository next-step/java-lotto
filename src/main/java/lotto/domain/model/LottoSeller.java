package lotto.domain.model;

import lotto.view.model.UserMoneyInput;

public class LottoSeller {
    public static final int PRICE = 1000;

    public int getPurchasableLottoCount(UserMoneyInput userInput) {
        return userInput.getMoneyAmount() / PRICE;
    }
}
