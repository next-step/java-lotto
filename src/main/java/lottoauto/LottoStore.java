package lottoauto;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int LOTTO_TICKET_PRICE = 1000;

    public List<LottoTicket> buyLottoTickets(int money) {
        int lottoTotalCount = money / LOTTO_TICKET_PRICE;

        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < lottoTotalCount; i++) {
            lottoTickets.add(new LottoTicket());
        }

        return lottoTickets;
    }


    public int price() {
        return LOTTO_TICKET_PRICE;
    }
}
