package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private static final int PRICE_PER_TICKET = 1000;
    private static final String NUMBER_REGEX = "\\d+";
    private LottoTicketBall lottoTicketBall = new LottoTicketBall();

    public List<LottoTicket> purchaseLotto(int purchaseAmount) {
        return generateTickets(calculateLottoCount(purchaseAmount));
    }
    private int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / PRICE_PER_TICKET;
    }
    private List<LottoTicket> generateTickets(int count) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i=0; i< count; i++) {
            tickets.add(lottoTicketBall.generateTicket());
        }
        return tickets;
    }

}

