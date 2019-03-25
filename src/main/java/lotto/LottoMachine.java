package lotto;

import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private UserLottoTicketGenerator lottoNumGenerator;
    private List<LottoTicket> lottoTickets;

    public LottoMachine(UserLottoTicketGenerator userLottoTicketGenerator) {
        this.lottoNumGenerator = userLottoTicketGenerator;
    }

    public List<LottoTicket> buyLottoTicket(int amount) {
        int salesQuantity = getSalesQuantity(amount);
        lottoTickets = new ArrayList<>();
        for (int i = 0; i < salesQuantity; i++) {
            lottoTickets.add(new LottoTicket(lottoNumGenerator.generateTicket()));
        }
        return lottoTickets;
    }


    private int getSalesQuantity(int amount) {
        return amount / 1000;
    }
}
