package lotto.service;

import lotto.domain.shop.LottoPurchaseMoney;
import lotto.domain.shop.LottoShop;
import lotto.domain.lotto.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public List<LottoTicket> purchaseLottoTicket(LottoPurchaseMoney lottoPurchaseMoney) {
        LottoShop lottoShop = new LottoShop();
        return lottoShop.publishLottoTickets(lottoPurchaseMoney);
    }

    public List<Integer> matchLottoTicket(List<LottoTicket> lottoTicketList, LottoTicket winLottoTicket) {
        List<Integer> lottoRankList= new ArrayList<>();

        for (LottoTicket lottoTicket : lottoTicketList) {
            int rank = lottoTicket.matchLottoTicketRank(winLottoTicket);
            lottoRankList.add(rank);
        }
        return lottoRankList;
    }
}
