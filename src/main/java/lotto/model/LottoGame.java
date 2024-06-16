package lotto.model;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {
    private final LottoTicketBundle userLottoTickets;

    public LottoGame(LottoTicketBundle userLottoTickets) {
        this.userLottoTickets = userLottoTickets;
    }

    public LottoGame(LottoTicketBundle manualLottoTickets, LottoTicketBundle autoLottoTickets) {
        this(new LottoTicketBundle(Stream.concat(manualLottoTickets.getLottoTickets().stream(), autoLottoTickets.getLottoTickets().stream())
                .collect(Collectors.toList())));
    }

    public LottoTicketBundle getUserLottoTickets() {
        return userLottoTickets;
    }
}
