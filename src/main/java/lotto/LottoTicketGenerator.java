package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketBall;
import lotto.domain.LottoTicketCollection;

public class LottoTicketGenerator {

    private static final int PRICE_PER_TICKET = 1000;

    private final LottoTicketBall lottoTicketBall;

    public LottoTicketGenerator(LottoTicketBall lottoTicketBall) {
        this.lottoTicketBall = lottoTicketBall;
    }

    public LottoTicketCollection purchaseLotto(int purchaseAmount, List<List<Integer>> numbers) {
        if (purchaseAmount < PRICE_PER_TICKET) {
            throw new IllegalArgumentException("로또를 구매할 수 없습니다.");
        }

        return new LottoTicketCollection(generateAutoTickets(calculateLottoCount(purchaseAmount)),
            generateManualTickets(numbers));
    }

    private int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / PRICE_PER_TICKET;
    }

    private List<LottoTicket> generateAutoTickets(int count) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(lottoTicketBall.generateTicket());
        }
        return tickets;
    }

    private List<LottoTicket> generateManualTickets(List<List<Integer>> numbers) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (List<Integer> number : numbers) {
            tickets.add(LottoTicket.createTicket(number));
        }
        return tickets;
    }
}
