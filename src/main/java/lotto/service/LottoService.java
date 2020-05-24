package lotto.service;

import lotto.domain.LottoShop;
import lotto.domain.LottoTicket;
import lotto.ui.InputView;

import java.util.List;

public class LottoService {

    private static LottoService lottoService;

    public static LottoService getInstance() {
        return lottoService == null ? new LottoService() : lottoService;
    }

    public List<LottoTicket> purchaseLottoTicket(int money) {
        LottoShop lottoShop = LottoShop.putMoney(money);
        return lottoShop.buyLottoTickets();
    }
}
