package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoService {

    private static final int PRICE_PER_TICKET = 1000;
    private LottoTicketBall lottoTicketBall = new LottoTicketBall();

    public List<LottoTicket> purchaseLotto(int purchaseAmount) {
        if (purchaseAmount < 1000) {
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

    public List<Integer> checkWinningResult(List<LottoTicket> tickets,
            List<Integer> winningNumbers) {
        List<Integer> result = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0));
        for (LottoTicket ticket : tickets) {
            int count = getCount(winningNumbers, ticket);
            result.set(count, result.get(count) + 1);
        }
        return result;
    }

    private int getCount(List<Integer> winningNumbers, LottoTicket ticket) {
        int count = 0;
        for (Integer number : ticket.displayNumbers()) {
            if (winningNumbers.contains(number)) {
                count++;
            }

        }
        return count;
    }
}

