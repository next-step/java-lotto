package lotto.application;

import lotto.domain.lotto.LottoTickets;
import lotto.domain.shop.Shop;

public class LottoService {
    public LottoTickets buyLottoTickets(long money) {
        return Shop.buyLottoTickets(money);
    }
}
