package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketBall;

public class LottoTicketGenerator {

    private static final int PRICE_PER_TICKET = 1000;

    private LottoTicketBall lottoTicketBall;

    public LottoTicketGenerator(LottoTicketBall lottoTicketBall) {
        this.lottoTicketBall = lottoTicketBall;
    }

    public List<LottoTicket> purchaseLotto(int purchaseAmount) {
        if (purchaseAmount < PRICE_PER_TICKET) {
            throw new IllegalArgumentException("로또를 구매할 수 없습니다.");
        }
        return generateTickets(calculateLottoCount(purchaseAmount));
    }

    private int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / PRICE_PER_TICKET;
    }

    private List<LottoTicket> generateTickets(int count) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(lottoTicketBall.generateTicket());
        }
        return tickets;
    }
}
