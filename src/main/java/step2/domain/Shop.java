package step2.domain;

import step2.constants.Price;
import step2.dto.LottoListDTO;
import step2.dto.MoneyDTO;
import step2.dto.ShopResponseDTO;

public class Shop {

    private final LottoGenerator lottoMachine = new LottoGenerator();

    public int calculateLottoCapacity(MoneyDTO money) {
        return money.getAmount() / Price.LOTTO_PRICE;
    }

    public ShopResponseDTO buyLotto(MoneyDTO money, int capacity) {
        if (capacity * Price.LOTTO_PRICE > money.getAmount()) {
            throw new IllegalArgumentException();
        }
        int change = money.getAmount() - capacity * Price.LOTTO_PRICE;
        LottoListDTO lottoList = lottoMachine.generateLottoList(capacity);
        ShopResponseDTO shopResponse = new ShopResponseDTO(money.getAmount(), capacity, lottoList, change);
        if (!isShopResponseValid(shopResponse)) {
            throw new IllegalArgumentException();
        }
        return shopResponse;
    }

    public boolean isShopResponseValid(ShopResponseDTO shopResponse) {
        return shopResponse.getLottoCount() * Price.LOTTO_PRICE + shopResponse.getChange()
                == shopResponse.getOriginMoney();
    }
}
