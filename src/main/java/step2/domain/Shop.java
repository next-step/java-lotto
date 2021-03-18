package step2.domain;

import step2.dto.Money;
import step2.dto.ShopResponse;

import java.util.List;

public class Shop {

    private static final int LOTTO_PRICE = 1000;

    private final LottoMachine lottoMachine = new LottoMachine();

    public int calculateLottoCapacity(Money money) {
        return money.getAmount() / LOTTO_PRICE;
    }

    public ShopResponse buyLotto(Money money, int capacity) {
        if (capacity * LOTTO_PRICE > money.getAmount()) throw new IllegalArgumentException();
        int change = money.getAmount() - capacity * LOTTO_PRICE;
        List<Lotto> lottoList = lottoMachine.issueLottoList(capacity);
        return new ShopResponse(money.getAmount(), capacity, lottoList, change);
    }
}
