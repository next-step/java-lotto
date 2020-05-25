package lotto.service;

import lotto.domain.LottoShop;
import lotto.domain.LottoTicket;

import java.util.List;

public class LottoService {

    public List<LottoTicket> purchaseLottoTicket(int money) {
        LottoShop lottoShop = new LottoShop();
        return lottoShop.publishLottoTickets(money);
    }
}
