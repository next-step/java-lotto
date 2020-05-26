package lotto.service;

import lotto.domain.LottoShop;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public List<LottoTicket> purchaseLottoTicket(int money) {
        LottoShop lottoShop = new LottoShop();
        return lottoShop.publishLottoTickets(money);
    }

    public List<Integer> matchLottoTicket(List<LottoTicket> lottoTicketList, String winningNumbers) {
        LottoTicket winLottoTicket = new LottoTicket(winningNumbers);
        List<Integer> lottoRankList= new ArrayList<>();

        for (LottoTicket lottoTicket : lottoTicketList) {
            int rank = lottoTicket.matchLottoTicketRank(winLottoTicket);
            lottoRankList.add(rank);
        }
        return lottoRankList;
    }
}
