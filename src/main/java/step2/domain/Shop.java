package step2.domain;

import step2.constants.Price;
import step2.dto.LottoListDTO;
import step2.dto.MoneyDTO;
import step2.dto.ShopResponseDTO;

public class Shop {

    private final LottoMachine lottoMachine = new LottoMachine();

    public int calculateLottoCapacity(MoneyDTO money) {
        return money.getAmount() / Price.LOTTO.getPrice();
    }

    public ShopResponseDTO buyLotto(MoneyDTO money, int capacity) {
        if (capacity * Price.LOTTO.getPrice() > money.getAmount()) {
            throw new IllegalArgumentException();
        }
        int change = money.getAmount() - capacity * Price.LOTTO.getPrice();
        LottoListDTO lottoList = lottoMachine.generateLottoList(capacity);
        ShopResponseDTO shopResponse = new ShopResponseDTO(money.getAmount(), capacity, lottoList, change);
        if (!valid(shopResponse)) {
            throw new IllegalArgumentException();
        }
        return shopResponse;
    }

    public boolean valid(ShopResponseDTO shopResponse) {
        return shopResponse.getLottoCount() * Price.LOTTO.getPrice() + shopResponse.getChange()
                == shopResponse.getOriginMoney();
    }
}
