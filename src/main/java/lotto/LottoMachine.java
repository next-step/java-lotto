package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.UserLottoTickets;

import java.util.List;

public class LottoMachine {
    private UserLottoTicketGenerator lottoNumGenerator;

    public LottoMachine(UserLottoTicketGenerator userLottoTicketGenerator) {
        this.lottoNumGenerator = userLottoTicketGenerator;
    }

    public UserLottoTickets buyLottoTicket(Money money, List<LottoTicket> manualTickets) {
        UserLottoTickets userLottoTickets = new UserLottoTickets();
        addManualTickets(manualTickets, userLottoTickets);

        int salesQuantity =  money.getTryAutoTicketsCount(manualTickets.size());
        for (int i = 0; i < salesQuantity; i++) {
            userLottoTickets.add(new LottoTicket(lottoNumGenerator.generateTicket()));
        }
        return userLottoTickets;
    }

    private void addManualTickets(List<LottoTicket> manualTickets, UserLottoTickets userLottoTickets) {
        for (LottoTicket manualTicket : manualTickets) {
            userLottoTickets.add(manualTicket);
        }
    }
}
