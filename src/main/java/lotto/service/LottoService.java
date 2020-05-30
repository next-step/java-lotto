package lotto.service;

import lotto.domain.rank.LottoRank;
import lotto.domain.rank.LottoRankCalculator;
import lotto.domain.shop.LottoPurchaseMoney;
import lotto.domain.shop.LottoShop;
import lotto.domain.lotto.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public List<LottoTicket> purchaseLottoTicket(LottoPurchaseMoney lottoPurchaseMoney) {
        return LottoShop.publishLottoTickets(lottoPurchaseMoney);
    }

    public List<LottoRank> matchLottoTicket(List<LottoTicket> lottoTicketList, LottoRankCalculator lottoRankCalculator) {
        List<LottoRank> lottoRankList = new ArrayList<>();

        for (LottoTicket lottoTicket : lottoTicketList) {
            LottoRank resultRank = lottoRankCalculator.calculate(lottoTicket);
            lottoRankList.add(resultRank);
        }
        return lottoRankList;
    }
}
