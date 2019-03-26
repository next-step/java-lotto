package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.UserLottoTickets;

public class LottoMachine {
    private UserLottoTicketGenerator lottoNumGenerator;

    public LottoMachine(UserLottoTicketGenerator userLottoTicketGenerator) {
        this.lottoNumGenerator = userLottoTicketGenerator;
    }

    public UserLottoTickets buyLottoTicket(Money money) {
        UserLottoTickets userLottoTickets = new UserLottoTickets();
        int salesQuantity =  money.getBuyTicketsCount();
        for (int i = 0; i < salesQuantity; i++) {
            userLottoTickets.add(new LottoTicket(lottoNumGenerator.generateTicket()));
        }
        return userLottoTickets;
    }}
