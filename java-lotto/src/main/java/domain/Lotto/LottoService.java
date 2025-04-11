package domain.Lotto;

import java.util.*;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;

    public Lottos generateLottos(LottoRequest request, int purchaseAmount) {
        int manualCount = request.getManualTicketCount();
        int autoCount = (purchaseAmount / LOTTO_PRICE) - manualCount;

        List<LottoTicket> manualTickets = request.toManualTickets();
        List<LottoTicket> autoTickets = generateLottoTickets(autoCount);

        return new Lottos(manualTickets, autoTickets);
    }

    public List<LottoTicket> generateLottoTickets(int count) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(new LottoTicket());
        }
        return tickets;
    }

    public LottoResult calculateResults(List<LottoTicket> tickets, WinningLotto winningLotto) {
        return LottoResult.from(tickets, winningLotto);
    }
}
