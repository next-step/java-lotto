package lotto;

import java.util.List;

public class LottoShop {

    public static final int LOTTO_PRICE = 1000;

    private final LottoCashier lottoCashier = new LottoCashier();

    public List<Lotto> buy(String moneyString) {
        return lottoCashier.pay(moneyString);
    }

}
