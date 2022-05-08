package lotto.model;

import java.util.ArrayList;
import java.util.List;

public final class Store {

    private static final long PRODUCT_PRICE = 1_000L;

    public Store() {
    }

    public List<Lotto> delivery(long money) {
        long count = money / PRODUCT_PRICE;
        List<Lotto> lotteryTickets = new ArrayList<>();
        while (count-- != 0) {
            lotteryTickets.add(deliverLotto());
        }
        return lotteryTickets;
    }

    private Lotto deliverLotto() {
        return LottoFactory.apply();
    }

}