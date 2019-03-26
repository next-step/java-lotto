package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.UserLottoTickets;

public class LottoMachine {
    private UserLottoTicketGenerator lottoNumGenerator;

    public LottoMachine(UserLottoTicketGenerator userLottoTicketGenerator) {
        this.lottoNumGenerator = userLottoTicketGenerator;
    }

    public UserLottoTickets buyLottoTicket(int amount) {
        UserLottoTickets userLottoTickets = new UserLottoTickets();
        int salesQuantity = getSalesQuantity(amount);
        for (int i = 0; i < salesQuantity; i++) {
            userLottoTickets.add(new LottoTicket(lottoNumGenerator.generateTicket()));
        }
        return userLottoTickets;
    }

    private int getSalesQuantity(int amount) {
        return amount / 1_000;
    }
}
