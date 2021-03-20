package step2.domain;

import step2.dto.ShopResponse;
import step2.utils.Price;

import java.util.List;

public class Shop {

    private final LottoFactory lottoMachine = new LottoFactory();

    public int calculateLottoCapacity(Money money) {
        return money.getAmount() / Price.LOTTO_PRICE;
    }

    public ShopResponse buyLotto(Money money, int capacity) {
        if (capacity * Price.LOTTO_PRICE > money.getAmount()) {
            throw new IllegalArgumentException();
        }
        int change = money.getAmount() - capacity * Price.LOTTO_PRICE;
        Lottos lottos = new Lottos(lottoMachine.issueLottoList(capacity));
        ShopResponse shopResponse = new ShopResponse(money.getAmount(), capacity, lottos, change);
        if (!isShopResponseValid(shopResponse)) {
            throw new IllegalArgumentException();
        }
        return shopResponse;
    }

    public boolean isShopResponseValid(ShopResponse shopResponse) {
        return shopResponse.getLottoCount() * Price.LOTTO_PRICE + shopResponse.getChange()
                == shopResponse.getOriginMoney();
    }
}
