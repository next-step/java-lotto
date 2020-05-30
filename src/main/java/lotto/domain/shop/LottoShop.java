package lotto.domain.shop;

import lotto.domain.lotto.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    private LottoShop() {

    }

    public static List<LottoTicket> publishLottoTickets(LottoPurchaseMoney lottoPurchaseMoney) {
        int lottoTicketCount = lottoPurchaseMoney.getLottoTicketCount();
        List<LottoTicket> lottoTicketList = new ArrayList<>();

        for (int i = 0; i < lottoTicketCount; i++) {
            lottoTicketList.add(new LottoTicket());
        }

        return lottoTicketList;
    }

}
