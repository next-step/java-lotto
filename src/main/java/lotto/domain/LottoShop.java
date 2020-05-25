package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    private final static int LOTTO_PRICE = 1000;

    public List<LottoTicket> publishLottoTickets(int inputMoney) {
        int lottoTicketCount = getLottoTicketCount(inputMoney);
        List<LottoTicket> lottoTicketList = new ArrayList<>();

        for (int i = 0; i < lottoTicketCount; i++) {
            lottoTicketList.add(new LottoTicket());
        }

        return lottoTicketList;
    }

    private static int getLottoTicketCount(int money) {
        return money / LOTTO_PRICE;
    }
}
