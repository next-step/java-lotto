package lotto.service;

import lotto.domain.LottoShop;
import lotto.domain.LottoTicket;

import java.util.List;

public class LottoService {

    public List<LottoTicket> purchaseLottoTicket(int money) {
        LottoShop lottoShop = new LottoShop();
        return lottoShop.publishLottoTickets(money);
    }

    public LottoTicket matchLottoTicket(List<LottoTicket> lottoTicketList, String winningNumbers) {
        LottoTicket winLottoTicket = new LottoTicket(winningNumbers);

        return null;
    }
}
