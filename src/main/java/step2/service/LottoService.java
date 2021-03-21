package step2.service;

import step2.domain.Judge;
import step2.domain.Lotto;
import step2.domain.Money;
import step2.domain.Shop;
import step2.dto.JudgeResponse;
import step2.dto.ShopResponse;

public class LottoService {

    private final Shop shop = new Shop();
    private final Judge judge = new Judge();

    public ShopResponse buyManualLotto(Money money) {
        int capacity = shop.calculateLottoCapacity(money);
        return shop.buyLotto(money, capacity);
    }

    public JudgeResponse getLottoResult(ShopResponse shopResponse, Lotto winningLotto) {
        return judge.calculateResult(shopResponse, winningLotto);
    }
}
